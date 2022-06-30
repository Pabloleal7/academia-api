package com.example.academiaapi.service.exceptions;

public class UnauthorizeException extends RuntimeException{
    public UnauthorizeException(String msg) {
        super(msg);
    }
}
