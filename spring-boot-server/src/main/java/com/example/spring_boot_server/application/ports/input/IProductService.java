package com.example.spring_boot_server.application.ports.input;

import com.example.spring_boot_server.domain.entities.Product.ProductIndexEntity;
import com.example.spring_boot_server.domain.externals.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface IProductService {
    Result<Page<ProductIndexEntity>> index(String strFilter, Pageable request);
    Result<ProductIndexEntity> read(UUID id);
    /*
    Result<ProductIndexEntity> create(ProductRequestEntity entity, UUID responsableId);
    Result<ProductIndexEntity> read(UUID id);
    Result<ProductIndexEntity> update(UUID id, ProductRequestEntity entity, UUID responsableId);
    Result<ProductIndexEntity> delete(UUID id, UUID responsableId);
    */
}