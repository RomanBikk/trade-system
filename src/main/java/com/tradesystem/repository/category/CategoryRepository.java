package com.tradesystem.repository.category;

import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.entity.ProductEntity;

import java.util.List;

public interface CategoryRepository {
     //CategoryEntity findById(Long id);
     CategoryEntity save(CategoryEntity categoryEntity);
     //void update(CategoryEntity categoryEntity);
     //void delete(CategoryEntity categoryEntity);
    //ProductEntity findProductById(Long id);
    List<CategoryEntity> findAll();
}
