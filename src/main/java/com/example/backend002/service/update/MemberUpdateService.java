package com.example.backend002.service.update;

import com.example.backend002.constant.BookStoreConstant;
import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.dao.repository.MemberRepository;
import com.example.backend002.exceptions.NotFoundException;
import com.example.backend002.model.request.update.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberUpdateService {

    private final MemberRepository memberRepository;

    public void updateMemberById(Integer id, MemberUpdateRequest memberUpdateRequest) {
        log.info("Updating member with ID: {}", id);
        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(id);

        if (memberEntityOptional.isPresent()) {
            MemberEntity memberEntity = memberEntityOptional.get();

            if (memberUpdateRequest.getName() != null) {
                memberEntity.setName(memberUpdateRequest.getName());
            }
            if (memberUpdateRequest.getEmail() != null) {
                memberEntity.setEmail(memberUpdateRequest.getEmail());
            }
            if (memberUpdateRequest.getPassword() != null) {
                memberEntity.setPassword(memberUpdateRequest.getPassword());
            }

            memberRepository.save(memberEntity);
            log.info("Member updated successfully with ID: {}", id);
        } else {
            throw new NotFoundException(BookStoreConstant.MEMBER_NOT_FOUND);
        }
    }

}
