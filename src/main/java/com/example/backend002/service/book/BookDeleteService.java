package com.example.backend002.service.book;

import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookDeleteService {

    private final BookRepository bookRepository;


    public void deleteBookById(Integer id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found by " +id ));
        bookRepository.deleteById(book.getId().intValue());
    }

}
