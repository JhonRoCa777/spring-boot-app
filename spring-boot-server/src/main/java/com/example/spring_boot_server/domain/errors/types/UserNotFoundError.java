package com.example.spring_boot_server.domain.errors.types;

import com.example.spring_boot_server.domain.errors.GeneralError;

public class UserNotFoundError extends GeneralError {
    public UserNotFoundError() {
        super("Usuario NO Registrado");
    }
}