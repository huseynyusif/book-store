package com.example.backend002.service.user;

import com.example.backend002.dao.entity.LibraryEntity;
import com.example.backend002.dao.entity.UserEntity;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.dao.repository.UserRepository;
import com.example.backend002.exceptions.NotFoundException;
import com.example.backend002.model.request.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserUpdateService {

    private final UserRepository userRepository;
    private final LibraryRepository libraryRepository;


    public void updateUserById(Integer id, UserRequest userRequest) {
        log.info("Updating user with ID: {}",id);
        Optional<UserEntity> userEntityId = userRepository.findById(id);

        if (userEntityId.isPresent()) {
            UserEntity userEntity = userEntityId.get();
            if (userRequest.getName() != null) {
                userEntity.setName(userRequest.getName());
            }
            if (userRequest.getEmail() != null) {
                userEntity.setEmail(userRequest.getEmail());
            }
            if (userRequest.getPassword() != null) {
                userEntity.setPassword(userRequest.getPassword());
            }
            if (userRequest.getLibrary() != null &&
                    userRequest.getLibrary().getId() != null) {
                Optional<LibraryEntity> optionalLibraryEntity =
                        libraryRepository.findById(userRequest.getLibrary().getId());
                if (optionalLibraryEntity.isPresent()) {
                    LibraryEntity library = optionalLibraryEntity.get();
                    userEntity.setLibrary(library);
                } else {
                    throw new NotFoundException
                            ("A library with the specified "+
                                    userRequest.getLibrary().getId()+" was not found.");

                }
            }if (userRequest.getLibrary() == null ||  userRequest.getLibrary().getId() == null){
                userEntity.setLibrary(null);
            }
            userRepository.save(userEntity);
            log.info("User updated successfully with ID: {}", id);
        } else {
            throw new NotFoundException("User not found");
        }

    }
}
