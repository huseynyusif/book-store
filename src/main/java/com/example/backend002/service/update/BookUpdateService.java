package com.example.backend002.service.update;

import com.example.backend002.constant.BookStoreConstant;
import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.enums.BookStatus;
import com.example.backend002.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class BookUpdateService {

    private final BookRepository bookRepository;

    public void updateBookStatus(Integer bookId, BookStatus newStatus) {

        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BookStoreConstant.BOOK_NOT_FOUND));

        bookEntity.setStatus(newStatus);

        bookRepository.save(bookEntity);
    }
}
