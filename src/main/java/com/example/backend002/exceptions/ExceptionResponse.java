package com.example.backend002.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record ExceptionResponse (
        LocalDateTime timeStamp,
        String message,
        String details
){
}
