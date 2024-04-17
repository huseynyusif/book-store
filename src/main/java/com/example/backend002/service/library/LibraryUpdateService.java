package com.example.backend002.service.library;

import com.example.backend002.dao.entity.LibraryEntity;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.model.request.LibraryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LibraryUpdateService {

    private final LibraryRepository libraryRepository;

    public void updateLibraryById(Integer id, LibraryRequest libraryRequest) {
        log.info("Updating library with ID: {}", id);
        LibraryEntity entity = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NOT_FOUND_LIBRARY"));
        //Requestden gelen deyerleri aliram
        String newName = libraryRequest.getName();
        String newLocation = libraryRequest.getLocation();

        //Eger name veya locationda bir deyisiklik varsa sadece o hisseleri guncelle
        if (newName != null && !newName.equals(entity.getName())) {
            entity.setName(newName);
        }
        if (newLocation != null && !newLocation.equals(entity.getLocation())) {
            entity.setLocation(newLocation);
        }

        //Deyisiklik olubsa Entity-e save ele
        if (!entity.getName().equals(libraryRequest.getName()) || !entity.getLocation().equals(libraryRequest.getLocation())) {
            libraryRepository.save(entity);
            log.info("Library updated successfully with ID: {}", id);
        } else {
            log.info("No changes detected for library with ID: {}", id);
        }
    }
}
