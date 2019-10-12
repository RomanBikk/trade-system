package com.tradesystem.converter;

import com.tradesystem.controller.rest.dto.ProductDto;
import com.tradesystem.entity.ProductEntity;
import com.tradesystem.model.Category;
import com.tradesystem.model.Product;

import java.util.Optional;

import static com.tradesystem.converter.CategoryConverter.convertToCategory;
import static com.tradesystem.converter.CategoryConverter.convertToCategoryEntity;

public interface ProductConverter {

    static Product convertToProduct(ProductEntity productEntity) {
        return Optional.ofNullable(productEntity)
                .map(p -> Product.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .description(p.getDescription())
                        .category(convertToCategory(p.getCategory()))
                        .build()
                ).orElse(null);
    }

    static ProductEntity convertToProductEntity(Product product) {
        return Optional.ofNullable(product)
                .map(p -> ProductEntity.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .description(p.getDescription())
                        .category(convertToCategoryEntity(p.getCategory()))
                        .build()
                ).orElse(null);
    }

    static ProductDto convertToProductDto(Product product) {
        return Optional.ofNullable(product)
                .map(p -> ProductDto.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .description(p.getDescription())
                        .categoryId(
                                Optional.ofNullable(p.getCategory())
                                        .map(Category::getId)
                                        .orElse(null)
                        )
                        .build()
                ).orElse(null);
    }

    static Product convertToProduct(ProductDto productDto) {
        return Optional.ofNullable(productDto)
                .map(p -> Product.builder()
                        .name(p.name)
                        .description(p.description)
                        .category(
                                Optional.ofNullable(p.categoryId)
                                        .map(categoryId -> Category.builder().id(categoryId).build())
                                        .orElse(null)
                        )
                        .build()
                ).orElse(null);
    }
}