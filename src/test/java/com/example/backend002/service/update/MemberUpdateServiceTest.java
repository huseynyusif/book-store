package com.example.backend002.service.update;

import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.dao.repository.MemberRepository;
import com.example.backend002.exceptions.NotFoundException;
import com.example.backend002.model.request.update.MemberUpdateRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberUpdateServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberUpdateService memberUpdateService;

    @Test
    void updateMemberById_WhenMemberExists_ShouldUpdateMember() {
        // Given
        int memberId = 1;
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberId);
        memberEntity.setName("Old Name");
        memberEntity.setEmail("old@gmail.com");
        memberEntity.setPassword("oldPassword");

        MemberUpdateRequest updateRequest = new MemberUpdateRequest();
        updateRequest.setName("New Name");
        updateRequest.setEmail("new@gmail.com");
        updateRequest.setPassword("newPassword");

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(memberEntity));

        // When
        memberUpdateService.updateMemberById(memberId, updateRequest);

        // Then
        assertEquals(updateRequest.getName(), memberEntity.getName());
        assertEquals(updateRequest.getEmail(), memberEntity.getEmail());
        assertEquals(updateRequest.getPassword(), memberEntity.getPassword());
        verify(memberRepository).save(memberEntity);
    }

    @Test
    void updateMemberById_WhenMemberDoesNotExist_ShouldThrowNotFoundException() {
        // Given
        int memberId = 1;
        when(memberRepository.findById(memberId)).thenReturn(Optional.empty());
        MemberUpdateRequest updateRequest = new MemberUpdateRequest();

        // When & Then
        assertThrows(NotFoundException.class, () -> {
            memberUpdateService.updateMemberById(memberId, updateRequest);
        });
    }

}