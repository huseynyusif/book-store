package com.example.backend002.mapper;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.model.request.create.MemberCreateRequest;
import com.example.backend002.model.response.MemberResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberMapperTest {

    private final MemberMapper memberMapper = new MemberMapperImpl();

    @Test
    void requestToEntityTest() {
        // given
        MemberCreateRequest memberCreateRequest = new MemberCreateRequest();
        memberCreateRequest.setName("Huseyn");
        memberCreateRequest.setEmail("Yusifov");
        memberCreateRequest.setPassword("password");

        List<BookEntity> bookEntities = new ArrayList<>();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(1L);
        bookEntity.setTitle("Book Title");
        bookEntities.add(bookEntity);

        // when
        MemberEntity memberEntity = memberMapper.requestToEntity(memberCreateRequest, bookEntities);

        // then
        assertEquals(memberCreateRequest.getName(), memberEntity.getName());
        assertEquals(memberCreateRequest.getEmail(), memberEntity.getEmail());
        assertEquals(memberCreateRequest.getPassword(), memberEntity.getPassword());

        assertEquals(1, memberEntity.getBooks().size());
        assertEquals(bookEntity, memberEntity.getBooks().get(0));
    }


    @Test
    void entityToResponse() {
        //given
        MemberEntity memberEntity = MemberEntity.builder()
                .id(1)
                .name("Huseyn")
                .password("12345")
                .email("huseyn@gmail.com")
                .build();

        MemberResponse expected = MemberResponse.builder()
                .id(1)
                .name("Huseyn")
                .password("12345")
                .email("huseyn@gmail.com")
                .build();
        //when
        MemberResponse actual = memberMapper.entityToResponse(memberEntity);
        //then
        Assertions.assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}