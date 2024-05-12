package com.example.backend002.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private List<BookResponse> books = new ArrayList<>();
}
