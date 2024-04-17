package com.example.backend002.model.response;

import com.example.backend002.dao.entity.LibraryEntity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {

    private String title;
    private String author;
    private String status;
    private LibraryResponse library;

}
