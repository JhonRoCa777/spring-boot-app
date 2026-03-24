package com.example.spring_boot_server.domain.errors.types;

import com.example.spring_boot_server.domain.errors.GeneralError;

public class ProductNotActiveError extends GeneralError {
    public ProductNotActiveError() {
        super("Producto Inactivo");
    }
}