package com.example.backend002.mapper;

import com.example.backend002.dao.entity.LibraryEntity;
import com.example.backend002.dao.entity.UserEntity;
import com.example.backend002.model.request.LibraryCreateRequest;
import com.example.backend002.model.request.LibraryRequest;
import com.example.backend002.model.response.LibraryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {

    LibraryEntity requestToEntity (LibraryRequest libraryRequest);

    LibraryRequest entityToRequest(LibraryEntity libraryEntity);

    LibraryEntity responseToEntity(LibraryResponse libraryResponse);

    LibraryResponse entityToResponse(LibraryEntity libraryEntity);

    LibraryCreateRequest entityToCreateRequest(LibraryEntity libraryEntity);

    LibraryEntity createRequestToEntity(LibraryCreateRequest libraryCreateRequest);
}
