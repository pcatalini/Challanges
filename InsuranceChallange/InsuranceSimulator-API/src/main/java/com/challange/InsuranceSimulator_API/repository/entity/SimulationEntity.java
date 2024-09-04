package com.challange.InsuranceSimulator_API.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimulationEntity {

    @Id
    private String id;
    private String externalUserId;
    private String userName;
    private String userEmail;
    private Double price;
    private String tier;
}
