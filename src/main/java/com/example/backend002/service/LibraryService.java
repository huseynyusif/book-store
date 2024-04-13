package com.example.backend002.service;

import com.example.backend002.dao.entity.LibraryEntity;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.mapper.LibraryMapper;
import com.example.backend002.model.request.LibraryRequest;
import com.example.backend002.model.response.LibraryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public LibraryService(LibraryRepository libraryRepository, LibraryMapper libraryMapper) {
        this.libraryRepository = libraryRepository;
        this.libraryMapper = libraryMapper;
    }

    public void addLibrary(LibraryRequest libraryRequest){
        log.info("Adding a new library: {}", libraryRequest.getName());
        var entity = libraryMapper.requestToEntity(libraryRequest);

        libraryRepository.save(entity);
        log.info("Library added successfully: {}", libraryRequest.getName());
    }

    public List<LibraryResponse> getLibraries() {
        log.info("Getting all libraries");
        List<LibraryEntity> libraryEntities = libraryRepository.findAll();
        log.info("Retrieved {} libraries", libraryEntities.size());
        return libraryEntities.stream().map(libraryMapper::entityToResponse).collect(Collectors.toList());
    }

    public LibraryResponse getLibraryById(Integer id) {
        log.info("Getting library with ID: {}", id);
        LibraryEntity entity = libraryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("NOT_FOUND_LIBRARY: "+id));
        log.info("Retrieved library with ID: {}", id);
        return libraryMapper.entityToResponse(entity);
    }

    public void deleteLibraryById(Integer id){
        log.info("Deleting library with ID: {}", id);
        libraryRepository.deleteById(id);
        log.info("Library deleted successfully with ID: {}", id);
    }

    public void updateLibraryById(Integer id,LibraryRequest libraryRequest) {
        log.info("Updating library with ID: {}", id);
        LibraryEntity entityId = libraryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("NOT_FOUND_LIBRARY"));

        entityId.setName(libraryRequest.getName());
        entityId.setLocation(libraryRequest.getLocation());

        libraryRepository.save(entityId);
        log.info("Library updated successfully with ID: {}", id);
    }
}
