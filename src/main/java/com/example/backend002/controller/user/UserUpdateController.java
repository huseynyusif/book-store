package com.example.backend002.controller.user;

import com.example.backend002.model.request.UserRequest;
import com.example.backend002.service.user.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserUpdateController {

    private final UserUpdateService userUpdateService;

    @PutMapping("/update/{id}")
    public void updateUserById(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        userUpdateService.updateUserById(id,userRequest);
    }
}
