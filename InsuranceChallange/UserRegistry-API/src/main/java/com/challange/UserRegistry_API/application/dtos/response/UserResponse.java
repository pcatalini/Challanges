package com.challange.UserRegistry_API.application.dtos.response;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private Integer age;
    private Double salary;
    private Boolean isMarried;
    private Integer numberOfSon;

}
