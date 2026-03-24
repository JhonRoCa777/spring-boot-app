package com.example.spring_boot_server.application.ports.output;

import com.example.spring_boot_server.domain.entities.Product.ProductIndexEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.UUID;

public interface IProductRepository {
    Page<ProductIndexEntity> index(String strFilter, Pageable request);
    Optional<ProductIndexEntity> read(UUID id);
    /*
    Result<ProductIndexEntity> create(ProductRequestEntity entity, UUID responsableId);
    Result<ProductIndexEntity> update(UUID id, ProductRequestEntity entity, UUID responsableId);
    Result<ProductIndexEntity> delete(UUID id, UUID responsableId);
    */
}