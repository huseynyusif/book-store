package com.example.backend002.service.user;

import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.dao.repository.UserRepository;
import com.example.backend002.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDeleteService {

    private final UserRepository userRepository;


    public void deleteUserById(Integer id) {
        log.info("Delete user with ID: {}",id);
        userRepository.deleteById(id);
        log.info("User deleted successfully with ID: {}",id);
    }
}
