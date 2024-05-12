package com.example.backend002.mapper;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.model.request.create.BookCreateRequest;
import com.example.backend002.model.request.save.BookSaveRequest;
import com.example.backend002.model.response.BookResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookCreateRequest entityToRequest(BookEntity bookEntity);

    BookEntity requestToEntity(BookCreateRequest bookCreateRequest);

    BookResponse entityToResponse(BookEntity entity);

    List<BookResponse> entitiesToResponses(List<BookEntity> entities);

    BookSaveRequest entityToSaveRequest(BookEntity bookEntity);
}
