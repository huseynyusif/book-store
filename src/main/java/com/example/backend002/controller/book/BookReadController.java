package com.example.backend002.controller.book;

import com.example.backend002.model.response.BookResponse;
import com.example.backend002.service.book.BookReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookReadController {

    private final BookReadService bookReadService;

    @GetMapping("/all")
    public List<BookResponse> getAllBooks(){
        return bookReadService.getAllBooks();
    }

    @GetMapping("/get/{id}")
    public BookResponse getBookById(@PathVariable Integer id){
        return bookReadService.getBookById(id);
    }
}
