package com.example.spring_boot_server.infrastructure.validators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserLoginValidator(
        @NotBlank(message = "El tipo de documento es requerido")
        @Pattern(regexp = "CC|CE|PP", message = "Tipo de documento inválido")
        String documentType,

        @NotBlank(message = "El documento es requerido")
        String document,

        @NotBlank(message = "La contraseña es requerida")
        String password
) { }
