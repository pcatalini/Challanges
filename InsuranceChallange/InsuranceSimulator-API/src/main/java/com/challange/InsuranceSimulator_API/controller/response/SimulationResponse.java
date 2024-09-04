package com.challange.InsuranceSimulator_API.controller.response;

import com.challange.InsuranceSimulator_API.service.dto.SimulationDTO;
import lombok.Builder;
import lombok.Data;
@Data
public class SimulationResponse{
    private String id;
    private Double price;
    private String tier;
}
