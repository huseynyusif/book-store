package com.example.backend002.controller.book;

import com.example.backend002.model.request.BookRequest;
import com.example.backend002.service.book.BookUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookUpdateController {

    private final BookUpdateService bookUpdateService;

    @PutMapping("/update/{id}")
    public void updateBookById(@PathVariable Integer id,
                               @RequestBody BookRequest bookRequest){
        bookUpdateService.updateBookById(id,bookRequest);
    }
}
