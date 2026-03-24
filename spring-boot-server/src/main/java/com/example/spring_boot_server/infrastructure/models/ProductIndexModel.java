package com.example.spring_boot_server.infrastructure.models;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ProductIndexModel {
    UUID getId();
    String getName();
    int getAmount();
    float getPrice();
    LocalDateTime getCreatedAt();
    UUID getCreatedById();
}