package com.example.backend002.controller;


import com.example.backend002.dao.entity.UserEntity;
import com.example.backend002.model.request.LibraryRequest;
import com.example.backend002.model.request.UserRequest;
import com.example.backend002.model.response.UserResponse;
import com.example.backend002.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody @Valid UserRequest userRequest) {
        userService.addUser(userRequest);
    }

    @GetMapping()
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    public void updateUserById(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        userService.updateUserById(id,userRequest);
    }
}
