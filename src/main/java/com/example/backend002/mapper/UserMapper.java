package com.example.backend002.mapper;

import com.example.backend002.dao.entity.UserEntity;
import com.example.backend002.model.request.LibraryCreateRequest;
import com.example.backend002.model.request.UserRequest;
import com.example.backend002.model.response.UserResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse EntityToResponse(UserEntity userEntity);


    UserEntity ResponseToEntity(UserResponse userResponse);

    UserRequest EntityToRequest(UserEntity userEntity);

    UserEntity RequestToEntity(UserRequest userRequest);


}
