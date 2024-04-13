package com.example.backend002.service;

import com.example.backend002.dao.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService{

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void deleteBookById(Integer id){
        bookRepository.deleteById(id);
    }
    public void add(){}
}
