package com.example.backend002.controller.save;

import com.example.backend002.model.request.save.BookSaveRequest;
import com.example.backend002.service.save.BookSaveService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookSaveController {

    private final BookSaveService bookSaveService;

    @PostMapping("/add/{id}")
    public void saveBook(@PathVariable Integer id,@RequestBody BookSaveRequest bookSaveRequest){
        bookSaveService.saveBook(id,bookSaveRequest);
    }
}
