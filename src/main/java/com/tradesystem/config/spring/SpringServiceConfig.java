package com.tradesystem.config.spring;

import com.tradesystem.repository.hibernate.HibernateProductRepository;
import com.tradesystem.service.product.DefaultProductService;
import com.tradesystem.service.product.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringServiceConfig {

    @Bean
    public ProductService getProductService() {
        return new DefaultProductService(new HibernateProductRepository());
    }
}
