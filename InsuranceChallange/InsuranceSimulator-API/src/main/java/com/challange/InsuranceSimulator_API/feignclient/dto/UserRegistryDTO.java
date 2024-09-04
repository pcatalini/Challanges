package com.challange.InsuranceSimulator_API.feignclient.dto;

import lombok.Data;

@Data
public class UserRegistryDTO {

    private String id;
    private String name;
    private String email;
    private Integer age;
    private Double salary;
    private Boolean isMarried;
    private Integer numberOfSon;
}
