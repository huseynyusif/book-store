package com.example.backend002.controller.book;

import com.example.backend002.model.request.BookRequest;
import com.example.backend002.service.book.BookCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookCreateController {

    private final BookCreateService bookCreateService;

    @PostMapping("/add")
    public void addBook(@RequestBody BookRequest bookRequest){
        bookCreateService.addBook(bookRequest);
    }
}
