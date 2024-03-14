package com.study.library.controller.advice;

import com.study.library.exception.SavaException;
import com.study.library.exception.ValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(SavaException.class)
    public ResponseEntity<?> saveException(SavaException e) {
        return  ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(ValidException.class)
    public ResponseEntity<?> saveException(ValidException e) {
        return  ResponseEntity.internalServerError().body(e.getErrorMap());
    }
}
