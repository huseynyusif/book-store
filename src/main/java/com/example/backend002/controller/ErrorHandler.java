package com.example.backend002.controller;

import com.example.backend002.exceptions.ExceptionResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handle(ConstraintViolationException ex) {
        log.error("ConstraintViolationException ", ex);
        List<ExceptionResponse> errors = new ArrayList<>();

        ex.getConstraintViolations()
                .forEach(e -> errors.add(new ExceptionResponse(e.getMessage())));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        log.error("Validation exception: ", ex);
        List<ExceptionResponse> errors = new ArrayList<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(o -> errors.add(new ExceptionResponse(o.getDefaultMessage())));
        return ResponseEntity.status(status).body(errors);
    }
}
