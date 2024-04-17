package com.example.backend002.controller.library;

import com.example.backend002.model.request.LibraryRequest;
import com.example.backend002.service.library.LibraryCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("libraries")
public class LibraryCreateController {

    private final LibraryCreateService libraryCreateService;

    @PostMapping("/add")
    public void addLibrary(@RequestBody LibraryRequest libraryRequest){
        libraryCreateService.addLibrary(libraryRequest);
    }
}
