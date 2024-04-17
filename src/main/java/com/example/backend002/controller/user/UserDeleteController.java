package com.example.backend002.controller.user;

import com.example.backend002.service.user.UserDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserDeleteController {

    private final UserDeleteService userDeleteService;

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userDeleteService.deleteUserById(id);
    }
}
