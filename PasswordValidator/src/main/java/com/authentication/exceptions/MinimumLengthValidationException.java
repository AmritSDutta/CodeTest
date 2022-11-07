package com.authentication.exceptions;

public class MinimumLengthValidationException extends ValidationException{
    public MinimumLengthValidationException(String message) {
        super(message);
    }
}
