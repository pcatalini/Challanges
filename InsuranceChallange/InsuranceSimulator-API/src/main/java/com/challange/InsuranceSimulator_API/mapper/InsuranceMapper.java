package com.challange.InsuranceSimulator_API.mapper;

import com.challange.InsuranceSimulator_API.controller.response.SimulationResponse;
import com.challange.InsuranceSimulator_API.repository.entity.SimulationEntity;
import com.challange.InsuranceSimulator_API.service.dto.SimulationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "tier", target = "tier")
    @Mapping(source = "price", target = "price")
    SimulationResponse toUserResponse(SimulationEntity simulationEntity);

    SimulationEntity toUserEntity(SimulationDTO simulationDTO);
}
