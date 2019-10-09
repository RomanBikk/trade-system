package com.tradesystem.service.category;

import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.model.Category;
import com.tradesystem.repository.hibernate.HibernateCrudRepository;
import com.tradesystem.repository.category.CategoryRepository;

public class DefaultCategoryService extends HibernateCrudRepository<CategoryEntity> implements CategoryService {
    private final CategoryRepository categoryRepository;
    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return convertToCategory(categoryRepository.save(convertToCategoryEntity(category)));
    }

   private Category convertToCategory(CategoryEntity categoryEntityEntity) {
        return Category.builder().id(categoryEntityEntity.getId()).name(categoryEntityEntity.getName()).build();
    }
    private CategoryEntity convertToCategoryEntity(Category category) {
        return CategoryEntity.builder().id(category.getId()).name(category.getName()).build();
    }


}
