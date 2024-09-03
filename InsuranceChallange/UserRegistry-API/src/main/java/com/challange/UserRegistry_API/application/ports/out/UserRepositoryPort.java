package com.challange.UserRegistry_API.application.ports.out;

import com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.entity.UserEntity;

import java.util.Optional;

public interface UserRepositoryPort {
    Optional<UserEntity> findById(final String id);
}
