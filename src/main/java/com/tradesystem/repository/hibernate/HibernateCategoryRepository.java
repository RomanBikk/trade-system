package com.tradesystem.repository.hibernate;

import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.repository.category.CategoryRepository;

public class HibernateCategoryRepository extends HibernateCrudRepository<CategoryEntity> implements CategoryRepository {

}
