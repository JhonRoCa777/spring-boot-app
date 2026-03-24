package com.example.spring_boot_server.domain.entities.User;

public record UserRegisterEntity(
        String documentType,
        String document,
        String names,
        String lastNames,
        String password
) {}