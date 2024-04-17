package com.example.backend002.mapper;

import com.example.backend002.dao.entity.UserEntity;
import com.example.backend002.model.request.UserCreateRequest;
import com.example.backend002.model.request.UserRequest;
import com.example.backend002.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse entityToResponse(UserEntity userEntity);


    UserEntity responseToEntity(UserResponse userResponse);

    UserRequest entityToRequest(UserEntity userEntity);

    UserEntity requestToEntity(UserRequest userRequest);

    UserCreateRequest entityToCreateRequest(UserEntity userEntity);

    UserEntity createRequestToEntity(UserCreateRequest userCreateRequest);
}
