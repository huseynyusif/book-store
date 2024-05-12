package com.example.backend002.mapper;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.model.request.create.MemberCreateRequest;
import com.example.backend002.model.response.MemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "books",source = "bookEntities")
    MemberEntity requestToEntity(MemberCreateRequest memberCreateRequest, List<BookEntity> bookEntities);

    MemberResponse entityToResponse(MemberEntity memberEntity);
}
