package com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.repository;

import com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringUserRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findById(final String id);

}
