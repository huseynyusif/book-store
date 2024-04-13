package com.example.backend002.model.response;


import com.example.backend002.dao.entity.LibraryEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private LibraryResponse library;

}
