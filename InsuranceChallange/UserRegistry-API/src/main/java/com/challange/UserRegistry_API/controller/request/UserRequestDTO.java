package com.challange.UserRegistry_API.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UserRequestDTO {

    @NotNull
    private String name;
    @Email
    private String email;

}
