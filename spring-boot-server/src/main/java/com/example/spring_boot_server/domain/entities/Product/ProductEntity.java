package com.example.spring_boot_server.domain.entities.Product;

import com.example.spring_boot_server.domain.entities.User.UserEntity;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductEntity(
        UUID id,
        String name,
        int amount,
        float price,
        LocalDateTime createdAt,
        UUID createdById,
        UserEntity createdUser,
        LocalDateTime updatedAt,
        UUID updatedById,
        UserEntity updatedUser,
        LocalDateTime deletedAt,
        UUID deletedById,
        UserEntity deletedUser
) {}