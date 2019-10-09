package com.tradesystem.service.category;

import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.model.Category;

import java.util.List;

public interface CategoryService {
    List findAll();
    Category save(Category product);
    //List findProductsByCategory();
}
