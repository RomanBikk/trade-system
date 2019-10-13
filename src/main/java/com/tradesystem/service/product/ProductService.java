package com.tradesystem.service.product;

import com.tradesystem.model.Product;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
}
