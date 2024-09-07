package com.rajat.learn.TMS.exceptions;

public class InvalidRequestException extends RuntimeException {

    // Default constructor
    public InvalidRequestException() {
        super("Invalid request.");
    }

    // Constructor that accepts a custom message
    public InvalidRequestException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public InvalidRequestException(Throwable cause) {
        super(cause);
    }
}
