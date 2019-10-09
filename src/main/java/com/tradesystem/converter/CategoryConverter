package com.tradesystem.converter;

import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.model.Category;

import java.util.Optional;

public interface CategoryConverter {

    static Category convertToCategory(CategoryEntity categoryEntity) {
        return Optional.ofNullable(categoryEntity)
                .map(category -> Category.builder()
                        .id(categoryEntity.getId())
                        .name(categoryEntity.getName())
                        .build()
                )
                .orElse(null);
    }

    static CategoryEntity convertToCategoryEntity(Category category) {
        return Optional.ofNullable(category)
                .map(c -> CategoryEntity.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .build()
                )
                .orElse(null);
    }
}