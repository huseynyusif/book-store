package com.example.backend002.service.library;

import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.mapper.LibraryMapper;
import com.example.backend002.model.request.LibraryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LibraryCreateService {

    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public void addLibrary(LibraryRequest libraryRequest) {
        log.info("Adding a new library: {}", libraryRequest.getName() + ", " + libraryRequest.getLocation());
        var entity = libraryMapper.requestToEntity(libraryRequest);

        libraryRepository.save(entity);
        log.info("Library added successfully: {}", libraryRequest.getName());
    }

}
