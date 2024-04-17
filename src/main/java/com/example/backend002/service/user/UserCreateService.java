package com.example.backend002.service.user;

import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.dao.repository.UserRepository;
import com.example.backend002.mapper.UserMapper;
import com.example.backend002.model.request.UserCreateRequest;
import com.example.backend002.model.request.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserCreateService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public void addUser(UserRequest userRequest) {
        log.info("Adding a new user: {}", userRequest.getName());

        var entity = userMapper.requestToEntity(userRequest);

        log.info("User added successfully: {}",userRequest.getName());

        userRepository.save(entity);
    }

    public void addBook(Integer id, UserCreateRequest userCreateRequest) {
//        UserEntity userEntity = userRepository.findById(id)
//                .orElseThrow(()-> new RuntimeException("USER_NOT_FOUND"));
//
//        List<BookEntity> books = bookRepository.findAllById(userCreateRequest.getBooks().stream()
//                .map(BookCreateRequest::getId)
//                .collect(Collectors.toList()));
//
//        userEntity.getBooks().addAll(books);
//
//        userRepository.save(userEntity);
//    }
    }
}
