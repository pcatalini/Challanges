package com.challange.UserRegistry_API.application.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UserRequest {

    @NotNull
    private String name;
    @Email
    private String email;
    private Integer age;
    private Double salary;
    private Boolean isMarried;
    private Integer numberOfSon;


}
