package com.example.backend002.model.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BookRequest {
    private String title;
    private String author;
}
