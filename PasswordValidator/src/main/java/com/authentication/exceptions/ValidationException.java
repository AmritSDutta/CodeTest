package com.authentication.exceptions;


/**
 * Base exception for password validation
 */
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }
}
