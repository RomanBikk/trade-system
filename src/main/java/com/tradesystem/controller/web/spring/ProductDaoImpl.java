package com.tradesystem.controller.web.spring;

import com.tradesystem.entity.ProductEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;

public class ProductDaoImpl implements ProductDao {

    public final JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long save(ProductEntity productEntity) {
        return null;
    }

    @Override
    public ProductEntity findById(Long id) {
        return null;
    }

    @Override
    public Collection<ProductEntity> findAllProducts() {
        return null;
    }
}
