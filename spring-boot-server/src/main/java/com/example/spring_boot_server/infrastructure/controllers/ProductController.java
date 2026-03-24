package com.example.spring_boot_server.infrastructure.controllers;

import com.example.spring_boot_server.application.ports.input.IProductService;
import com.example.spring_boot_server.domain.entities.Product.ProductIndexEntity;
import com.example.spring_boot_server.domain.externals.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final IProductService _service;

    @GetMapping("")
    public Result<Page<ProductIndexEntity>> index(
            @RequestParam(defaultValue = "") String strFilter,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "name") String orderBy,
            @RequestParam(defaultValue = "true") boolean orderAsc
    ) {
        Sort sort = orderAsc ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();
        return _service.index(strFilter, PageRequest.of(pageNumber, pageSize, sort));
    }

    @GetMapping("/{id}")
    public Result<ProductIndexEntity> read(@PathVariable UUID id) {
        return _service.read(id);
    }
}