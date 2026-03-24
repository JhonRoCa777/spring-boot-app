package com.example.spring_boot_server.domain.errors;

import org.springframework.http.HttpStatus;

public class UnprocessableError extends BaseError {
    public UnprocessableError(String message) {
        super(HttpStatus.UNPROCESSABLE_CONTENT, message);
    }
}