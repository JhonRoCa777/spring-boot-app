package com.example.spring_boot_server.domain.errors;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class BaseError {
    private final HttpStatus code;
    private final String message;
}