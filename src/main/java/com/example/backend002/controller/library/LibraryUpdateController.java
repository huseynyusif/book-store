package com.example.backend002.controller.library;

import com.example.backend002.model.request.LibraryRequest;
import com.example.backend002.service.library.LibraryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("libraries")
public class LibraryUpdateController {

    private final LibraryUpdateService libraryUpdateService;

    @PutMapping("/update/{id}")
    public void updateLibraryById(@PathVariable Integer id, @RequestBody LibraryRequest libraryRequest){
        libraryUpdateService.updateLibraryById(id,libraryRequest);
    }
}
