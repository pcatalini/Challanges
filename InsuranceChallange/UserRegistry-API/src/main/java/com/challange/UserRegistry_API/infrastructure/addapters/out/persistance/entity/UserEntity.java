package com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserEntity {

    @Id
    private String id;
    private String name;
    private String email;

}
