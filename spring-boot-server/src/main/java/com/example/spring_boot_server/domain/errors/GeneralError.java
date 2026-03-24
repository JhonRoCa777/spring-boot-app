package com.example.spring_boot_server.domain.errors;

import org.springframework.http.HttpStatus;

public class GeneralError extends BaseError {
    public GeneralError(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}