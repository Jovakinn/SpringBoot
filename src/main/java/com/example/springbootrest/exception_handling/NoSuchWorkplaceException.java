package com.example.springbootrest.exception_handling;

public class NoSuchWorkplaceException extends RuntimeException{
    public NoSuchWorkplaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
