package com.example.backend002.model.response;

import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private Integer cost;
    private BookStatus status;

}
