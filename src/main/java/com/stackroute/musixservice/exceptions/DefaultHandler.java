package com.stackroute.musixservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultHandler{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(Exception e){
        return new ResponseEntity<>("some internal problem : "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
