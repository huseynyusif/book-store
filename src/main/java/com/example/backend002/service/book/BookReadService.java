package com.example.backend002.service.book;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.exceptions.NotFoundException;
import com.example.backend002.mapper.BookMapper;
import com.example.backend002.model.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookReadService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public List<BookResponse> getAllBooks() {
        List<BookEntity> bookEntity = bookRepository.findAll();
        return bookEntity.stream().map(bookMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public BookResponse getBookById(Integer id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));

        return bookMapper.entityToResponse(bookEntity);
    }



}
