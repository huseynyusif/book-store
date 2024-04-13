package com.example.backend002.service;


import com.example.backend002.dao.entity.LibraryEntity;
import com.example.backend002.dao.entity.UserEntity;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.dao.repository.UserRepository;
import com.example.backend002.mapper.UserMapper;
import com.example.backend002.model.request.LibraryRequest;
import com.example.backend002.model.request.UserRequest;
import com.example.backend002.model.response.UserResponse;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final LibraryRepository libraryRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, LibraryRepository libraryRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.libraryRepository = libraryRepository;
    }

    public void addUser(UserRequest userRequest) {
        log.info("Adding a new user: {}", userRequest.getName());

        var entity = userMapper.RequestToEntity(userRequest);

        log.info("User added successfully: {}",userRequest.getName());

        userRepository.save(entity);
    }


    public List<UserResponse> getUsers() {
        log.info("Getting all users");
        List<UserEntity> userEntities = userRepository.findAll();
        log.info("Retrieved {} users",userEntities.size());

        return userEntities.stream()
                .map(userMapper::EntityToResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Integer id) {
        log.info("Getting user with ID: {}",id);
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("USER_NOT_FOUND"));
        log.info("Retrieved user with ID: {}",id);
        return userMapper.EntityToResponse(userEntity);
    }

    public void deleteUserById(Integer id) {
        log.info("Delete user with ID: {}",id);
        userRepository.deleteById(id);
        log.info("User deleted successfully with ID: {}",id);
    }

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
            if (userRequest.getLibrary() != null && userRequest.getLibrary().getId() != null) {
                Optional<LibraryEntity> optionalLibraryEntity = libraryRepository.findById(userRequest.getLibrary().getId());
                if (optionalLibraryEntity.isPresent()) {
                    LibraryEntity library = optionalLibraryEntity.get();
                    userEntity.setLibrary(library);
                } else {
                    throw new RuntimeException("A library with the specified ID was not found.");
                }
            }if (userRequest.getLibrary() == null ||  userRequest.getLibrary().getId() == null){
                userEntity.setLibrary(null);
            }
            userRepository.save(userEntity);
            log.info("User updated successfully with ID: {}", id);
        } else {
            throw new RuntimeException("User not found");
        }

    }
}
