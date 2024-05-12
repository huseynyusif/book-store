package com.example.backend002.model.request.save;

import com.example.backend002.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookSaveRequest {
    private BookStatus status;
}
