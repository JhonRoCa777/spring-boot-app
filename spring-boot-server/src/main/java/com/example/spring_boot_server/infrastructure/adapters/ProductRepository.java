package com.example.spring_boot_server.infrastructure.adapters;

import com.example.spring_boot_server.application.ports.output.IProductRepository;
import com.example.spring_boot_server.domain.entities.Product.ProductIndexEntity;
import com.example.spring_boot_server.infrastructure.mappers.ProductMapper;
import com.example.spring_boot_server.infrastructure.models.ProductIndexModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductRepository implements IProductRepository {

    private final ProductDAO _dao;
    private final ProductMapper _mapper;

    @Override
    public Page<ProductIndexEntity> index(String strFilter, Pageable pageable) {
        Page<ProductIndexModel> modelPage = _dao.findAllProjection(
                strFilter != null ? strFilter : "", pageable);

        List<ProductIndexEntity> entityList = _mapper.toEntityList(modelPage.getContent());

        return new PageImpl<>(entityList, pageable, modelPage.getTotalElements());
    }

    @Override
    public Optional<ProductIndexEntity> read(UUID id) {
        return _dao.findProjection(id).map(_mapper::toEntity);
    }
}
