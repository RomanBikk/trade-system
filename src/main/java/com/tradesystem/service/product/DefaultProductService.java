package com.tradesystem.service.product;

import com.tradesystem.entity.ProductEntity;
import com.tradesystem.model.Product;
import com.tradesystem.repository.product.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAll().stream().map(this::convertToProduct).collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        return convertToProduct(productRepository.save(convertToProductEntity(product)));
    }

    private Product convertToProduct(ProductEntity productEntity) {
        return Product.builder().id(productEntity.getId()).name(productEntity.getName()).build();
    }
    private ProductEntity convertToProductEntity(Product product) {
        return ProductEntity.builder().id(product.getId()).name(product.getName()).build();
    }
}
