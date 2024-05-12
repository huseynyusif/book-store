package com.example.backend002.controller.update;

import com.example.backend002.enums.BookStatus;
import com.example.backend002.service.update.BookUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class BookUpdateController {

    private final BookUpdateService adminUpdateService;

    @PutMapping("/books/{bookId}/status")
    public ResponseEntity<String> updateBookStatus(@PathVariable Integer bookId, @RequestParam BookStatus newStatus) {
        adminUpdateService.updateBookStatus(bookId, newStatus);
        return ResponseEntity.ok("Book status Updated");
    }
}
