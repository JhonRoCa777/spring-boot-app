package com.example.spring_boot_server.domain.entities.User;

import com.example.spring_boot_server.domain.entities.Product.ProductEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record UserEntity(
        UUID id,
        String names,
        String lastNames,
        String documentType,
        String document,
        String role,
        LocalDateTime createdAt,
        UUID createdById,
        UserEntity createdUser,
        LocalDateTime updatedAt,
        UUID updatedById,
        UserEntity updatedUser,
        LocalDateTime deletedAt,
        UUID deletedById,
        UserEntity deletedUser,
        List<ProductEntity> products
) {}