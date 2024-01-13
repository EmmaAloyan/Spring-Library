package com.example.springbootlibrary.exception;

public class UncorrectedRequestException extends RuntimeException{
    public UncorrectedRequestException(String message) {
        super(message);
    }
}
