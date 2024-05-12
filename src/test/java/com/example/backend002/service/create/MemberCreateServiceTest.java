package com.example.backend002.service.create;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.MemberRepository;
import com.example.backend002.mapper.MemberMapper;
import com.example.backend002.model.request.create.MemberCreateRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.example.backend002.enums.BookStatus.ACTIVE;
import static com.example.backend002.enums.BookStatus.INACTIVE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberCreateServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private MemberMapper memberMapper;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private MemberCreateService memberCreateService;
    @Test
    void addMember() {
        // Given
        MemberCreateRequest memberCreateRequest = new MemberCreateRequest();
        memberCreateRequest.setName("Huseyn");
        memberCreateRequest.setPassword("12345");
        memberCreateRequest.setEmail("huseyn@gmail.com");
        memberCreateRequest.setBooks(Arrays.asList(1, 2, 3)); // Example book ids

        List<Integer> activeBookIds = Arrays.asList(1, 2, 3); // Example active book ids
        when(bookRepository.findActiveBookIds()).thenReturn(activeBookIds);


        List<BookEntity> bookEntities = Arrays.asList(

        );
        when(bookRepository.findByIdIn(activeBookIds)).thenReturn(bookEntities);


        MemberEntity memberEntity = new MemberEntity();
        when(memberMapper.requestToEntity(memberCreateRequest, bookEntities)).thenReturn(memberEntity);

        // When
        memberCreateService.addMember(memberCreateRequest);

        // Then
        verify(memberRepository, times(1)).save(memberEntity);
    }
}