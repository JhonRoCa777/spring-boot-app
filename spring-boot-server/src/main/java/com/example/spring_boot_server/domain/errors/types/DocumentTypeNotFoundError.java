package com.example.spring_boot_server.domain.errors.types;

import com.example.spring_boot_server.domain.errors.GeneralError;

public class DocumentTypeNotFoundError extends GeneralError {
    public DocumentTypeNotFoundError() {
        super("Tipo de Documento NO Registrado");
    }
}