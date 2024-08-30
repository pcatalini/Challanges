package com.challange.UserRegistry_API.mapper;


import com.challange.UserRegistry_API.controller.request.UserRequestDTO;
import com.challange.UserRegistry_API.controller.response.UserResponseDTO;
import com.challange.UserRegistry_API.repository.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    UserResponseDTO toUserResponseDTO(UserModel userEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserModel toUserEntity(UserRequestDTO userRequestDTO);
}
