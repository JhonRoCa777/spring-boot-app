package com.example.spring_boot_server.domain.errors;

import org.springframework.http.HttpStatus;

public class UnauthorizedError extends BaseError {
    public UnauthorizedError() {
        super(HttpStatus.UNAUTHORIZED, "Sin Permisos");
    }
    public UnauthorizedError(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}