package com.example.springbootrest.exception_handling;

public class NoSuchEmployeeException extends RuntimeException {
    public NoSuchEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }
}
