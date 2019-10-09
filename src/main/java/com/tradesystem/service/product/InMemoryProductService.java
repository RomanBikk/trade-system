package com.tradesystem.service.product;

import com.tradesystem.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProductService implements ProductService {
    private AtomicInteger key = new AtomicInteger(0);
    private Map<Long, Product> products = new HashMap<>();

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product save(Product product) {
        long id = key.addAndGet(1);
        product.setId(id);
        products.put(id,product);
        return null;
    }
}
