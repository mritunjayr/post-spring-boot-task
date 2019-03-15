package com.stackroute.musixservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultHandlerException {

    //handling TrackNotFoundException exception
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<String> handler(TrackNotFoundException e){
        return new ResponseEntity<>("some internal problem : "+e.getMessage(), HttpStatus.NOT_FOUND);
    }

    //handling TrackAlreadyExistsException exception
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<String> entityHandler(TrackAlreadyExistsException e){
        return new ResponseEntity<>("input body is not valid  : "+e.getMessage(), HttpStatus.CONFLICT);
    }
}
