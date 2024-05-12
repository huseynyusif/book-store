package com.example.backend002.exceptions;


import java.time.LocalDateTime;

public record ExceptionResponse (
        LocalDateTime timeStamp,
        String message,
        String details
){
}
