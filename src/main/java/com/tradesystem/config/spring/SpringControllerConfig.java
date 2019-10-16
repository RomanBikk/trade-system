package com.tradesystem.config.spring;

import com.tradesystem.controller.rest.spring.SpringRestProductController;
import com.tradesystem.controller.web.spring.WebSpringProductController;
import com.tradesystem.service.product.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringControllerConfig {

    @Bean
    public SpringRestProductController getController(ProductService productService) {
        return new SpringRestProductController(productService);
    }

    @Bean
    public WebSpringProductController getWebController(ProductService productService) {
        return new WebSpringProductController(productService);
    }
}
