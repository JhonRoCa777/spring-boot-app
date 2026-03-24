package com.example.spring_boot_server.infrastructure.mappers;

import com.example.spring_boot_server.domain.entities.Product.ProductIndexEntity;
import com.example.spring_boot_server.infrastructure.models.ProductIndexModel;
import com.example.spring_boot_server.infrastructure.models.ProductModel;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductIndexEntity toEntity(ProductIndexModel model);

    ProductModel toModel(ProductIndexEntity entity);

    List<ProductIndexEntity> toEntityList(List<ProductIndexModel> modelList);
}