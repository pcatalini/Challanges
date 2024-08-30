package com.challange.UserRegistry_API.service;

import com.challange.UserRegistry_API.controller.request.UserRequestDTO;
import com.challange.UserRegistry_API.controller.response.UserResponseDTO;
import com.challange.UserRegistry_API.mapper.UserMapper;
import com.challange.UserRegistry_API.repository.UserRepository;
import com.challange.UserRegistry_API.repository.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    public UserService(final UserRepository userRepository,
                       final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    private UserRepository userRepository;
    private UserMapper userMapper;


    public UserResponseDTO createUser(final UserRequestDTO user){
        final UserModel userModel = userMapper.toUserEntity(user);
        return userMapper.toUserResponseDTO(userRepository.save(userModel));
    }

    public void deleteUser(final String userId){
        userRepository.deleteById(userId);
    }

    public Optional<UserResponseDTO> updateUserById(final String userId, final UserRequestDTO user){
        final Optional<UserModel> userById = userRepository.findById(userId);
        if (userById.isPresent()){
            final UserModel userEntity = userMapper.toUserEntity(user);
            userEntity.setId(userId);
            final UserModel savedUser = userRepository.save(userEntity);
            return Optional.of(userMapper.toUserResponseDTO(savedUser));
        }
        return Optional.empty();
    }

    public List<UserResponseDTO> getUsers(){
        return userRepository
                .findAll()
                .stream()
                .map(user -> userMapper.toUserResponseDTO(user))
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> getUser(final String userId){
            final Optional<UserModel> userById = userRepository.findById(userId);
            if(userById.isPresent()){
                final UserResponseDTO userResponseDTO = userMapper.toUserResponseDTO(userById.get());
                return Optional.of(userResponseDTO);
            }
            return Optional.empty();
    }
}
