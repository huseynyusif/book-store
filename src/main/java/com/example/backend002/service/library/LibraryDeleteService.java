package com.example.backend002.service.library;

import com.example.backend002.dao.entity.LibraryEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LibraryDeleteService {

    private final LibraryRepository libraryRepository;

    public ResponseEntity<String> deleteLibraryById(Integer id) {
        log.info("Deleting library with ID: {}", id);

        Optional<LibraryEntity> libraryOptional = libraryRepository.findById(id);
        if (libraryOptional.isEmpty()) {
            log.error("Library with ID {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Library with ID " + id + " not found");
        }

        try {
            libraryRepository.deleteById(id);
            log.info("Library deleted successfully with ID: {}", id);
            return ResponseEntity.ok("Library deleted successfully with ID: " + id);
        } catch (Exception e) {
            log.error("Error occurred while deleting library with ID {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while deleting library with ID " + id);
        }
    }
}
