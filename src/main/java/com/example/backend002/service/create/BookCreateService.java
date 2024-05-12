package com.example.backend002.service.create;


import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.enums.BookStatus;
import com.example.backend002.model.request.create.BookCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class BookCreateService {

    private final BookRepository bookRepository;

    public void addBook(BookCreateRequest bookCreateRequest) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookCreateRequest.getTitle());
        bookEntity.setAuthor(bookCreateRequest.getAuthor());
        bookEntity.setStatus(BookStatus.INACTIVE);


        bookRepository.save(bookEntity);
    }

}
