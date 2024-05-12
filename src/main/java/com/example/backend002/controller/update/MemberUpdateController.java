package com.example.backend002.controller.update;

import com.example.backend002.model.request.update.MemberUpdateRequest;
import com.example.backend002.service.update.MemberUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberUpdateController {

    private final MemberUpdateService memberUpdateService;

    @PutMapping("/update/{id}")
    public void updateMemberById(@PathVariable Integer id,@RequestBody MemberUpdateRequest memberUpdateRequest){

        memberUpdateService.updateMemberById(id,memberUpdateRequest);
    }
}
