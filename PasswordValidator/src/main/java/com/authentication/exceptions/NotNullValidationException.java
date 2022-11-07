package com.authentication.exceptions;

public class NotNullValidationException extends ValidationException{
    public NotNullValidationException(String message) {
        super(message);
    }
}
