package com.example.backend002.model.request;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    private List<BookCreateRequest> books = new ArrayList<>();
}
