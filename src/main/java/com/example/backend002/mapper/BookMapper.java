package com.example.backend002.mapper;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.model.request.BookCreateRequest;
import com.example.backend002.model.request.BookRequest;
import com.example.backend002.model.response.BookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity requestToEntity (BookRequest bookRequest);

    BookRequest entityToRequest(BookEntity bookEntity);

    BookEntity responseToEntity(BookResponse bookResponse);

    BookResponse entityToResponse(BookEntity bookEntity);

    BookCreateRequest entityToCreateRequest(BookEntity bookEntity);
    BookEntity CreateRequestToEntity(BookCreateRequest bookCreateRequest);

}
