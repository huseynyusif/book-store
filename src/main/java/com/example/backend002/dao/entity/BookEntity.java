package com.example.backend002.dao.entity;

import com.example.backend002.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private Integer cost;

    @Enumerated(EnumType.STRING)
    private BookStatus status;//String

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<MemberEntity> members = new ArrayList<>();
}
