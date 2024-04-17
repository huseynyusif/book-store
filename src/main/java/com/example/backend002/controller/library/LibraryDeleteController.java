package com.example.backend002.controller.library;

import com.example.backend002.service.library.LibraryDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("libraries")
public class LibraryDeleteController {

    private final LibraryDeleteService libraryDeleteService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLibraryById(@PathVariable Integer id){
        return libraryDeleteService.deleteLibraryById(id);
    }
}
