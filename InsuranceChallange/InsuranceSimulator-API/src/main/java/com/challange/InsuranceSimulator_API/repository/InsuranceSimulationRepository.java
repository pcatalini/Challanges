package com.challange.InsuranceSimulator_API.repository;

import com.challange.InsuranceSimulator_API.repository.entity.SimulationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InsuranceSimulationRepository extends MongoRepository<SimulationEntity, String> {

    Optional<SimulationEntity> findById(final String id);
}
