package com.challange.InsuranceSimulator_API.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimulationDTO {
    private Double price;
    private String tier;
}
