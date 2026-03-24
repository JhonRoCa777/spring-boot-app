package com.example.spring_boot_server.infrastructure.adapters;

import com.example.spring_boot_server.infrastructure.models.ProductIndexModel;
import com.example.spring_boot_server.infrastructure.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.UUID;

public interface ProductDAO extends JpaRepository<ProductModel, UUID> {
    @Query("SELECT p.id AS id, p.name AS name, p.amount AS amount, p.price AS price, p.createdAt AS createdAt, p.createdById AS createdById " +
            "FROM ProductModel p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<ProductIndexModel> findAllProjection(@Param("name") String name, Pageable pageable);

    @Query("SELECT p.id AS id, p.name AS name, p.amount AS amount, p.price AS price, p.createdAt AS createdAt, p.createdById AS createdById " +
            "FROM ProductModel p WHERE p.id = :id")
    Optional<ProductIndexModel> findProjection(@Param("id") UUID id);
}