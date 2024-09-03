package com.challange.UserRegistry_API.application.services;

import com.challange.UserRegistry_API.application.dtos.request.UserRequest;
import com.challange.UserRegistry_API.application.dtos.response.UserResponse;
import com.challange.UserRegistry_API.infrastructure.addapters.in.mapper.UserMapper;
import com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.entity.UserEntity;
import com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.repository.SpringUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    public UserService(final SpringUserRepository userRepository,
                       final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    private SpringUserRepository userRepository;
    private UserMapper userMapper;


    public UserResponse createUser(final UserRequest user){
        final UserEntity userModel = userMapper.toUserEntity(user);
        return userMapper.toUserResponseDTO(userRepository.save(userModel));
    }

    public void deleteUser(final String userId){
        userRepository.deleteById(userId);
    }

    public Optional<UserResponse> updateUserById(final String userId, final UserRequest user){
        final Optional<UserEntity> userById = userRepository.findById(userId);
        if (userById.isPresent()){
            final UserEntity userEntity = userMapper.toUserEntity(user);
            userEntity.setId(userId);
            final UserEntity savedUser = userRepository.save(userEntity);
            return Optional.of(userMapper.toUserResponseDTO(savedUser));
        }
        return Optional.empty();
    }

    public List<UserResponse> getUsers(){
        return userRepository
                .findAll()
                .stream()
                .map(user -> userMapper.toUserResponseDTO(user))
                .collect(Collectors.toList());
    }

    public Optional<UserResponse> getUser(final String userId){
            final Optional<UserEntity> userById = userRepository.findById(userId);
            if(userById.isPresent()){
                final UserResponse userResponseDTO = userMapper.toUserResponseDTO(userById.get());
                return Optional.of(userResponseDTO);
            }
            return Optional.empty();
    }
}
