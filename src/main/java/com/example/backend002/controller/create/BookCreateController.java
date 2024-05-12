package com.example.backend002.controller.create;

import com.example.backend002.model.request.create.BookCreateRequest;
import com.example.backend002.service.create.BookCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class BookCreateController {

    private final BookCreateService adminCreateService;

    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody BookCreateRequest bookCreateRequest) {
        adminCreateService.addBook(bookCreateRequest);
        return ResponseEntity.ok("New book added");
    }

}
