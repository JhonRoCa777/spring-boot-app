package com.example.spring_boot_server.domain.errors;

import org.springframework.http.HttpStatus;

public class ForbiddenError extends BaseError {
    public ForbiddenError() {
        super(HttpStatus.FORBIDDEN, "Debe Realizar Login");
    }
    public ForbiddenError(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}