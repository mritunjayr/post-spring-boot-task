package com.stackroute.musixservice.exceptions;

public class TrackAlreadyExistsException extends Exception{
    //constructor
    public TrackAlreadyExistsException(String message) {
        super(message);
    }
}
