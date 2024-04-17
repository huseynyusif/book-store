package com.example.backend002.controller.user;

import com.example.backend002.model.request.UserCreateRequest;
import com.example.backend002.model.request.UserRequest;
import com.example.backend002.service.user.UserCreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserCreateController {

    private final UserCreateService userCreateService;

    @PostMapping("/add")
    public void addUser(@RequestBody @Valid UserRequest userRequest) {
        userCreateService.addUser(userRequest);
    }

    @PostMapping("/add-book/{id}")
    public void addBook(@PathVariable Integer id, @RequestBody UserCreateRequest userCreateRequest){
        userCreateService.addBook(id,userCreateRequest);
    }
}
