package com.example.spring_boot_server.domain.errors.types;

import com.example.spring_boot_server.domain.errors.GeneralError;

public class UserNotActiveError extends GeneralError {
    public UserNotActiveError() {
        super("Usuario Inactivo");
    }
}