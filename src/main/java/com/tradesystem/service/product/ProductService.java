package com.tradesystem.service.product;

import com.tradesystem.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
}
