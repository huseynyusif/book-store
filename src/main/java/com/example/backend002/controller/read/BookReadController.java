package com.example.backend002.controller.read;

import com.example.backend002.model.response.BookResponse;
import com.example.backend002.service.read.BookReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookReadController {

    private final BookReadService bookService;


    @GetMapping("/search/price")
    public ResponseEntity<List<BookResponse>> findBooksByCostRange(@RequestParam Integer minCost, @RequestParam Integer maxCost) {
        List<BookResponse> books = bookService.findBooksByCostRange(minCost, maxCost);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/title")
    public ResponseEntity<List<BookResponse>> searchBookByTitlePrefix(@RequestParam String prefix){
        List<BookResponse> books = bookService.findByTitleStartingWith(prefix);
        return ResponseEntity.ok(books);
    }
}
