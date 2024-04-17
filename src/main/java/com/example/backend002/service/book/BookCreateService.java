package com.example.backend002.service.book;

import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.mapper.BookMapper;
import com.example.backend002.model.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookCreateService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public void addBook(BookRequest bookRequest) {
        var entity = bookMapper.requestToEntity(bookRequest);

        entity.setStatus("active");

        bookRepository.save(entity);
    }
}
