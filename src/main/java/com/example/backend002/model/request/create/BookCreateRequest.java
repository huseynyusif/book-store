package com.example.backend002.model.request.create;


import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateRequest {
    private Integer id;
    private String title;
    private String author;
    private Integer cost;
}
