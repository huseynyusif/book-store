package com.example.backend002.mapper;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.model.request.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity requestToEntity (BookRequest bookRequest);

    BookRequest entityToRequest(BookEntity bookEntity);

}
