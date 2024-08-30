package com.challange.UserRegistry_API.repository.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserModel {

    @Id
    private String id;
    private String name;
    private String email;

}
