package com.example.spring_boot_server.domain.errors;

import org.springframework.http.HttpStatus;

public class ConflictError extends BaseError {
    public ConflictError(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}