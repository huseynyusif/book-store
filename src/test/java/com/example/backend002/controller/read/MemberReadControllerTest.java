package com.example.backend002.controller.read;

import com.example.backend002.constant.BookStoreConstant;
import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.exceptions.NotFoundException;
import com.example.backend002.model.response.MemberResponse;
import com.example.backend002.service.read.MemberReadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static com.example.backend002.constant.BookStoreConstant.MEMBER_NOT_FOUND;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberReadController.class)
class MemberReadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberReadService memberReadService;

    @Test
    void getAllMembers() throws Exception{
        // Given
        List<MemberResponse> expectedResponses = Arrays.asList(
                MemberResponse.builder().id(1).name("Member 1").build(),
                MemberResponse.builder().id(2).name("Member 2").build()
        );

        when(memberReadService.getAllMembers()).thenReturn(expectedResponses);

        // When
        mockMvc.perform(get("/members/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Member 1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Member 2")));
        //Then
        verify(memberReadService, times(1)).getAllMembers();
    }

    @Test
    void getMemberById() throws Exception{
        final Integer ID = 1;

        MemberResponse memberResponse = MemberResponse.builder()
                .id(ID)
                .name("Huseyn")
                .email("huseyn@gmail.com")
                .password("123456")
                .build();

        when(memberReadService.getMemberById(ID)).thenReturn(memberResponse);

        mockMvc
                .perform(get("/members/"+ID))
                .andExpect(status().isOk());
    }

    @Test
    void getMemberById_Should_Return_Not_Found() throws Exception{
        final Integer ID =1;

        when(memberReadService.getMemberById(ID))
                .thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

        mockMvc
                .perform(get("/members/"+ID))
                .andExpect(status().isNotFound());
    }
}