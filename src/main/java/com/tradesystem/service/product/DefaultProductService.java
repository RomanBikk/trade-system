package com.tradesystem.service.product;

import com.tradesystem.converter.ProductConverter;
import com.tradesystem.entity.ProductEntity;
import com.tradesystem.model.Product;
import com.tradesystem.repository.product.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.tradesystem.converter.CategoryConverter.convertToCategory;

public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAll().stream().map(ProductConverter::convertToProduct).collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        return ProductConverter.convertToProduct(productRepository.save(ProductConverter.convertToProductEntity(product)));
    }



}
