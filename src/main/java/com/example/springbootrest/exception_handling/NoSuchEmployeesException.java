package com.example.springbootrest.exception_handling;

public class NoSuchEmployeesException extends RuntimeException {
    public NoSuchEmployeesException(String message, Throwable cause) {
        super(message, cause);
    }
}
