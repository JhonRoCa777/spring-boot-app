package com.example.spring_boot_server.domain.errors;

import org.springframework.http.HttpStatus;

public class InternalServerError extends BaseError {
    public InternalServerError() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor, por favor comuníquese con el área TIC.");
    }
    public InternalServerError(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}