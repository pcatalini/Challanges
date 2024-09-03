package com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.repository;

import com.challange.UserRegistry_API.application.ports.out.UserRepositoryPort;
import com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private SpringUserRepository repository;

    public UserRepositoryAdapter(SpringUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserEntity> findById(String id) {
        return repository.findById(id);
    }
}
