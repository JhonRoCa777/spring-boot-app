package com.example.spring_boot_server.infrastructure.validators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegisterValidator(
        @NotBlank(message = "El tipo de documento es requerido")
        @Pattern(regexp = "CC|CE|PP", message = "Tipo de documento inválido")
        String documentType,

        @NotBlank(message = "El documento es requerido")
        @Size(min = 5, max = 15, message = "El documento debe tener entre 5 y 15 caracteres")
        String document,

        @NotBlank(message = "El nombre es requerido")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String names,

        @NotBlank(message = "Los apellidos son requeridos")
        @Size(min = 2, max = 100, message = "Los apellidos deben tener entre 2 y 100 caracteres")
        String lastNames,

        @NotBlank(message = "La contraseña es requerida")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        String password
) { }
