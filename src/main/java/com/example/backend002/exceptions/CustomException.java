package com.example.backend002.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class CustomException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleAllException(Exception ex, WebRequest request) {
        log.error("Exception ", ex);
        return new ExceptionResponse(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
       return ErrorResponse.builder().message(exception.getMessage()).code(HttpStatus.BAD_REQUEST.name())
               .build();

    }

}
