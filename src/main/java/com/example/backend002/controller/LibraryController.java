package com.example.backend002.controller;

import com.example.backend002.model.request.LibraryRequest;
import com.example.backend002.model.response.LibraryResponse;
import com.example.backend002.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/add")
    public void addLibrary(@RequestBody LibraryRequest libraryRequest){
        libraryService.addLibrary(libraryRequest);
    }

    @PostMapping("/all")
    public List<LibraryResponse> getLibraries(){
        return libraryService.getLibraries();
    }

    @PostMapping("/get/{id}")
    public LibraryResponse getLibraryById(@PathVariable Integer id){
        return libraryService.getLibraryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLibraryById(@PathVariable Integer id){
        libraryService.deleteLibraryById(id);
    }

    @PutMapping("/update/{id}")
    public void updateLibraryById(@PathVariable Integer id,@RequestBody LibraryRequest libraryRequest){
        libraryService.updateLibraryById(id,libraryRequest);
    }

}
