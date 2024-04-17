package com.example.backend002.service.user;

import com.example.backend002.dao.entity.UserEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.dao.repository.UserRepository;
import com.example.backend002.mapper.UserMapper;
import com.example.backend002.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserReadService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;



    public List<UserResponse> getUsers() {
        log.info("Getting all users");
        List<UserEntity> userEntities = userRepository.findAll();
        log.info("Retrieved {} users",userEntities.size());

        return userEntities.stream()
                .map(userMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Integer id) {
        log.info("Getting user with ID: {}",id);
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User not found with ID: "+id));
        log.info("Retrieved user with ID: {}",id);
        return userMapper.entityToResponse(userEntity);
    }
}
