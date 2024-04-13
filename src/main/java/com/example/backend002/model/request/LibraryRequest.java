package com.example.backend002.model.request;

import com.example.backend002.dao.entity.UserEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LibraryRequest {

    private String name;
    private String location;

}
