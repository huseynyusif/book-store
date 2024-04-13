package com.example.backend002.model.response;

import com.example.backend002.dao.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryResponse {

    private Integer id;
    private String name;
    private String location;

}
