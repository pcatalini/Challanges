package com.challange.UserRegistry_API.infrastructure.addapters.in.mapper;


import com.challange.UserRegistry_API.application.dtos.request.UserRequest;
import com.challange.UserRegistry_API.application.dtos.response.UserResponse;
import com.challange.UserRegistry_API.infrastructure.addapters.out.persistance.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    UserResponse toUserResponseDTO(UserEntity userEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserEntity toUserEntity(UserRequest userRequestDTO);
}
