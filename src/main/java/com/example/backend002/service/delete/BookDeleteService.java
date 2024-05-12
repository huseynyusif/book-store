package com.example.backend002.service.delete;

import com.example.backend002.constant.BookStoreConstant;
import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class BookDeleteService {

    private final BookRepository bookRepository;

    public void deleteBook(Integer bookId) {
        log.info("Delete book with ID: {}",bookId);
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BookStoreConstant.BOOK_NOT_FOUND));

        bookRepository.delete(bookEntity);
        log.info("User deleted successfully with ID: {}",bookId);
    }
}
