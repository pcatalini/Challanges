package com.challange.UserRegistry_API.repository;

import com.challange.UserRegistry_API.repository.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel, String> {

    Optional<UserModel> findById(final String id);

}
