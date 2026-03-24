package com.example.spring_boot_server.domain.entities.Product;

import java.util.UUID;

public record ProductRequestEntity(
        String name,
        int amount,
        float price
) {}