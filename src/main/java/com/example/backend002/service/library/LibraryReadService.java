package com.example.backend002.service.library;

import com.example.backend002.dao.entity.LibraryEntity;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.mapper.LibraryMapper;
import com.example.backend002.model.response.LibraryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class LibraryReadService {

    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public LibraryResponse getLibraryById(Integer id) {
        log.info("Getting library with ID: {}", id);
        LibraryEntity entity = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NOT_FOUND_LIBRARY: " + id));
        log.info("Retrieved library with ID: {}", id);
        return libraryMapper.entityToResponse(entity);
    }

    public List<LibraryResponse> getLibraries() {
        log.info("Getting all libraries");
        List<LibraryEntity> libraryEntities = libraryRepository.findAll();
        log.info("Retrieved {} libraries", libraryEntities.size());
        return libraryEntities.stream().map(libraryMapper::entityToResponse).collect(Collectors.toList());
    }
}
