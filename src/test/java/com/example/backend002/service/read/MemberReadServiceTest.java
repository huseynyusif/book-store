package com.example.backend002.service.read;

import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.dao.repository.MemberRepository;
import com.example.backend002.mapper.MemberMapper;
import com.example.backend002.model.response.MemberResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MemberReadServiceTest {

    @InjectMocks
    private MemberReadService memberReadService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private MemberMapper memberMapper;

    public MemberReadServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllMembers() {
        // Given
        List<MemberEntity> memberEntities = new ArrayList<>();
        MemberEntity memberEntity = MemberEntity.builder()
                .id(1)
                .name("Huseyn")
                .password("12345")
                .email("huseyn@gmail.com")
                .build();
        memberEntities.add(memberEntity);

        List<MemberResponse> expectedMembers = new ArrayList<>();
        MemberResponse memberResponse = MemberResponse.builder()
                .id(1)
                .name("Huseyn")
                .password("12345")
                .email("huseyn@gmail.com")
                .build();
        expectedMembers.add(memberResponse);

        when(memberRepository.findAll()).thenReturn(memberEntities);
        when(memberMapper.entityToResponse(memberEntity)).thenReturn(memberResponse);

        // When
        List<MemberResponse> actualMembers = memberReadService.getAllMembers();

        // Then
        assertEquals(expectedMembers.size(), actualMembers.size());
        assertEquals(expectedMembers, actualMembers);

        verify(memberRepository).findAll();
        verify(memberMapper).entityToResponse(memberEntity);
    }

    @Test
    void getMemberById() {
        //Given
        Integer memberId = 1;
        MemberEntity memberEntity = MemberEntity.builder()
                .id(memberId)
                .name("Huseyn")
                .password("12345")
                .email("huseyn@gmail.com")
                .build();
        MemberResponse expectedResponse = MemberResponse.builder()
                .id(memberId)
                .name("Huseyn")
                .password("12345")
                .email("huseyn@gmail.com")
                .build();

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(memberEntity));
        when(memberMapper.entityToResponse(memberEntity)).thenReturn(expectedResponse);

        //When
        MemberResponse actualResponse = memberReadService.getMemberById(memberId);

        //Then
        assertThat(actualResponse).isNotNull();
        assertThat(actualResponse).isEqualTo(expectedResponse);

        verify(memberRepository, times(1)).findById(memberId);
        verify(memberMapper, times(1)).entityToResponse(memberEntity);
    }

    @Test
    void getMemberById_NotFound() {
        //Given
        Integer memberId = 1;
        when(memberRepository.findById(memberId)).thenReturn(Optional.empty());

        //When
        assertThatThrownBy(() -> memberReadService.getMemberById(memberId))
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("Member not found with ID: " + memberId);

        //Then
        verify(memberRepository, times(1)).findById(memberId);
        verify(memberMapper, never()).entityToResponse(any());
    }
}