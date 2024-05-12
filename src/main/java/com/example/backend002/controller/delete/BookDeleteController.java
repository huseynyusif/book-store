package com.example.backend002.controller.delete;

import com.example.backend002.service.delete.BookDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class BookDeleteController {

    private final BookDeleteService adminDeleteService;

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {
        adminDeleteService.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted");
    }
}
