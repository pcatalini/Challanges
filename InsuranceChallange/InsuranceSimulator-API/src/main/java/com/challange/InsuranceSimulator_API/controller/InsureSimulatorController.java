package com.challange.InsuranceSimulator_API.controller;

import com.challange.InsuranceSimulator_API.controller.request.AssetBodyRequest;
import com.challange.InsuranceSimulator_API.controller.response.SimulationResponse;
import com.challange.InsuranceSimulator_API.service.InsuranceSimulatorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/simulation")
public class InsureSimulatorController {

    private InsuranceSimulatorService insuranceService;

    public InsureSimulatorController(InsuranceSimulatorService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @Operation(summary = "insurance simulation", description = "Get a simulation for userId")
    @PostMapping("/{userId}")
    public ResponseEntity<SimulationResponse> simulate(@PathVariable String userId,
                                                       @RequestBody AssetBodyRequest asset) {
        return ResponseEntity.ok(insuranceService.simulationById(userId, asset));
    }




}
