package com.example.backend002.model.request;

import com.example.backend002.dao.entity.LibraryEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BookRequest {
    private String title;
    private String author;
    private LibraryCreateRequest library;
}
