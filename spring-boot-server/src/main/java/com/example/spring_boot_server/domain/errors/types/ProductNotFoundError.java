package com.example.spring_boot_server.domain.errors.types;

import com.example.spring_boot_server.domain.errors.GeneralError;

public class ProductNotFoundError extends GeneralError {
    public ProductNotFoundError() {
        super("Producto NO Registrado");
    }
}