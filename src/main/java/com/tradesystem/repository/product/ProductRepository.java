package com.tradesystem.repository.product;

import com.tradesystem.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    ProductEntity save(ProductEntity productEntity);
    //void update(ProductEntity productEntity);
    //void delete(ProductEntity productEntity);
    List<ProductEntity> findAll();
}
