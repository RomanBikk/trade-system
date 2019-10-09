package com.tradesystem.controller.web.servlet;

import com.tradesystem.controller.web.servlet.controller.web.servlet.CategoryController;
import com.tradesystem.controller.web.servlet.controller.web.servlet.ProductController;
import com.tradesystem.repository.hibernate.HibernateCategoryRepository;
import com.tradesystem.repository.hibernate.HibernateProductRepository;
import com.tradesystem.service.category.DefaultCategoryService;
import com.tradesystem.service.product.DefaultProductService;

public class WebControllerFactory {

    public  static <T> T getController (WebControllerName controllerName) {
        switch (controllerName){
            case PRODUCT:
                return (T)new ProductController(new DefaultProductService(new HibernateProductRepository()));
            case CATEGORY:
                return (T)new CategoryController(new DefaultCategoryService(new HibernateCategoryRepository()));
            default:
                throw new IllegalArgumentException(String.format("The %s web controller has not been found", controllerName));
        }
    }
}
