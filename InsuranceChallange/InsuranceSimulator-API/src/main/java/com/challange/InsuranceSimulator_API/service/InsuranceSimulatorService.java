package com.challange.InsuranceSimulator_API.service;

import com.challange.InsuranceSimulator_API.controller.request.AssetBodyRequest;
import com.challange.InsuranceSimulator_API.controller.response.SimulationResponse;
import com.challange.InsuranceSimulator_API.feignclient.UserRegistryFeign;
import com.challange.InsuranceSimulator_API.feignclient.dto.UserRegistryDTO;
import com.challange.InsuranceSimulator_API.mapper.InsuranceMapper;
import com.challange.InsuranceSimulator_API.repository.InsuranceSimulationRepository;
import com.challange.InsuranceSimulator_API.repository.entity.SimulationEntity;
import com.challange.InsuranceSimulator_API.service.dto.SimulationDTO;
import org.springframework.stereotype.Service;

@Service
public class InsuranceSimulatorService {


    private UserRegistryFeign userRegistryClient;
    private InsuranceSimulationRepository insuranceSimulationRepository;
    private InsuranceMapper insuranceMapper;

    public InsuranceSimulatorService(final UserRegistryFeign userRegistryClient,
                                     final InsuranceSimulationRepository insuranceSimulationRepository,
                                     final InsuranceMapper insuranceMapper) {
        this.userRegistryClient = userRegistryClient;
        this.insuranceSimulationRepository = insuranceSimulationRepository;
        this.insuranceMapper = insuranceMapper;
    }

    public SimulationResponse simulationById(final String userId, final AssetBodyRequest asset) {
        final var userById = userRegistryClient.getUserById(userId);

        final var simulationResponse = simulateInsurance(userById, asset);

        final var insuranceEntity = SimulationEntity.builder()
                .externalUserId(userById.getId())
                .userEmail(userById.getEmail())
                .userName(userById.getName())
                .price(simulationResponse.getPrice())
                .tier(simulationResponse.getTier())
                .build();

        insuranceSimulationRepository.save(insuranceEntity);

        return insuranceMapper.toUserResponse(insuranceEntity);
    }


    private SimulationDTO simulateInsurance(final UserRegistryDTO user, final AssetBodyRequest asset) {
        final double price = getPrice(user, asset.getPrice());
        final var simulationBuilder = SimulationDTO.builder();
        if (price < 2000) {
            simulationBuilder.tier("Silver");
        } else if (price < 5000) {
            simulationBuilder.tier("Gold");
        } else {
            simulationBuilder.tier("Diamond");
        }
        return simulationBuilder.price(price).build();
    }

    private static double getPrice(UserRegistryDTO user, Double priceOfAsset) {
        final double basePrice = 500;
        final double ageFactor = (user.getAge() > 50) ? 1.2 : 1.0;
        final double salaryFactor = (user.getSalary() > 50000) ? 1.5 : 1.0;
        final double marriageFactor = user.getIsMarried() ? 0.9 : 1.1;
        final double childrenFactor = (user.getNumberOfSon() > 0) ? 0.95 : 1.0;
        final double assetFactor = priceOfAsset / 10000;

        final double price = basePrice * ageFactor * salaryFactor * marriageFactor * childrenFactor * assetFactor;
        return price;
    }


}
