package com.example.backend002.controller.read;

import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.model.response.MemberResponse;
import com.example.backend002.service.read.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberReadController {

    private final MemberReadService memberReadService;

    @GetMapping("/all")
    public List<MemberResponse> getAllMembers(){
        return memberReadService.getAllMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable Integer id){
        return ResponseEntity.ok(memberReadService.getMemberById(id));
    }
}
