package com.tradesystem.service.category;

import com.tradesystem.converter.CategoryConverter;
import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.model.Category;
import com.tradesystem.repository.hibernate.HibernateCrudRepository;
import com.tradesystem.repository.category.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;
    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {

        return categoryRepository.findAll().stream().map(CategoryConverter::convertToCategory).collect(Collectors.toList());
    }

    @Override
    public Category save(Category category) {
        return CategoryConverter.convertToCategory(categoryRepository.save(CategoryConverter.convertToCategoryEntity(category)));
    }




}
