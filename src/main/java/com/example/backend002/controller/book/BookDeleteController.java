package com.example.backend002.controller.book;

import com.example.backend002.service.book.BookDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookDeleteController {

    private final BookDeleteService bookDeleteService;


    @DeleteMapping("/delete/{id}")
    public void deleteBookById(@PathVariable Integer id){
        bookDeleteService.deleteBookById(id);
    }
}
