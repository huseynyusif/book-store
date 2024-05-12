package com.example.backend002.model.request.create;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminCreateRequest {

    private String name;
    private String password;
    private String email;

}
