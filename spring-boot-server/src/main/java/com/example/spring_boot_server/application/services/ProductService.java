package com.example.spring_boot_server.application.services;

import com.example.spring_boot_server.application.ports.input.IProductService;
import com.example.spring_boot_server.application.ports.output.IProductRepository;
import com.example.spring_boot_server.domain.entities.Product.ProductIndexEntity;
import com.example.spring_boot_server.domain.errors.types.ProductNotFoundError;
import com.example.spring_boot_server.domain.externals.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository _repository;

    @Override
    public Result<Page<ProductIndexEntity>> index(String strFilter, Pageable pageable) {
        return Result.success(_repository.index(strFilter, pageable));
    }

    @Override
    public Result<ProductIndexEntity> read(UUID id) {
        return _repository.read(id)
                .map(Result::success)
                .orElseGet(() -> Result.failure(new ProductNotFoundError()));
    }
}