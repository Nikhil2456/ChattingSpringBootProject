package com.example.assignment.exception;

public class CustomException extends RuntimeException {
    //This is created to throw custom Exception message.
    public CustomException(String message) {
        super(message);
    }
}
