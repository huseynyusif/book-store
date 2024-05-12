package com.example.backend002.service.save;

import com.example.backend002.constant.BookStoreConstant;
import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.MemberRepository;
import com.example.backend002.enums.BookStatus;
import com.example.backend002.exceptions.NotFoundException;
import com.example.backend002.mapper.BookMapper;
import com.example.backend002.model.request.save.BookSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookSaveService {

    private final BookRepository bookRepository;

    public void saveBook(Integer id,BookSaveRequest bookSaveRequest){

      BookEntity bookEntity =  bookRepository.findById(id).orElseThrow(()->
              new NotFoundException(BookStoreConstant.BOOK_NOT_FOUND));

        BookStatus newStatus = bookSaveRequest.getStatus();

        bookEntity.setStatus(newStatus);

        bookRepository.save(bookEntity);
    }
}
