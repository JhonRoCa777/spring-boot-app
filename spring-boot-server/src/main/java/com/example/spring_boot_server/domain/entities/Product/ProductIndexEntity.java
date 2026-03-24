package com.example.spring_boot_server.domain.entities.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductIndexEntity(
        UUID id,
        String name,
        int amount,
        float price,
        LocalDateTime createdAt,
        UUID createdById
) {}