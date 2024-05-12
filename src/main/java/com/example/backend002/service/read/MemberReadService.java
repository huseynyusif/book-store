package com.example.backend002.service.read;

import com.example.backend002.constant.BookStoreConstant;
import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.dao.repository.MemberRepository;
import com.example.backend002.exceptions.NotFoundException;
import com.example.backend002.mapper.MemberMapper;
import com.example.backend002.model.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberReadService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    public List<MemberResponse> getAllMembers() {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        return memberEntities.stream()
                .map(memberMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public MemberResponse getMemberById(Integer memberId) {

        MemberEntity memberEntity = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Member not found with ID: " + memberId));

        log.info("Retrieved user with ID: {}", memberId);

        return memberMapper.entityToResponse(memberEntity);
    }
}
