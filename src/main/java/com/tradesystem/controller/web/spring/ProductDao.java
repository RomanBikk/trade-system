package com.tradesystem.controller.web.spring;

import com.tradesystem.entity.ProductEntity;

import java.util.Collection;

public interface ProductDao {
    Long save(ProductEntity productEntity);
    ProductEntity findById(Long id);
    Collection<ProductEntity> findAllProducts();
}
