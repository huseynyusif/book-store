package com.example.backend002.controller.create;

import com.example.backend002.model.request.create.MemberCreateRequest;
import com.example.backend002.service.create.MemberCreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberCreateController {

    private final MemberCreateService memberCreateService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMember(@RequestBody @Valid MemberCreateRequest memberCreateRequest){
        memberCreateService.addMember(memberCreateRequest);
    }

}
