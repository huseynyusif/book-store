package com.example.backend002.model.request.update;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateRequest {

    private String name;
    private String password;
    private String email;

}
