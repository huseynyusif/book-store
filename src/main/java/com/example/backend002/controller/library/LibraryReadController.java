package com.example.backend002.controller.library;

import com.example.backend002.model.response.LibraryResponse;
import com.example.backend002.service.library.LibraryReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("libraries")
public class LibraryReadController {

    private final LibraryReadService libraryReadService;

    @PostMapping("/all")
    public List<LibraryResponse> getLibraries(){
        return libraryReadService.getLibraries();
    }

    @PostMapping("/get/{id}")
    public LibraryResponse getLibraryById(@PathVariable Integer id){
        return libraryReadService.getLibraryById(id);
    }
}
