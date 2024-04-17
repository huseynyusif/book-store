package com.example.backend002.controller.user;

import com.example.backend002.model.response.UserResponse;
import com.example.backend002.service.user.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserReadController {

    private final UserReadService userReadService;


    @GetMapping()
    public List<UserResponse> getUsers() {
        return userReadService.getUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Integer id){
        return userReadService.getUserById(id);
    }
}
