package com.vuhocspringboot.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrolResponse> handleException(StudentNotFoundException exs)
    {
        StudentErrolResponse response = new StudentErrolResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exs.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrolResponse> handleException(Exception exs)
    {
        StudentErrolResponse response = new StudentErrolResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exs.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
