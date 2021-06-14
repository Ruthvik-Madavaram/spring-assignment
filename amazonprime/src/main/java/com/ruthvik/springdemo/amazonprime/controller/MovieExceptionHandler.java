package com.ruthvik.springdemo.amazonprime.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<com.ruthvik.springdemo.amazonprime.controller.MovieErrorResponse> handleException(com.ruthvik.springdemo.amazonprime.controller.MovieNotFoundException ex){
        com.ruthvik.springdemo.amazonprime.controller.MovieErrorResponse error = new com.ruthvik.springdemo.amazonprime.controller.MovieErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<com.ruthvik.springdemo.amazonprime.controller.MovieErrorResponse> handleException(Exception ex){
        com.ruthvik.springdemo.amazonprime.controller.MovieErrorResponse error = new com.ruthvik.springdemo.amazonprime.controller.MovieErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
