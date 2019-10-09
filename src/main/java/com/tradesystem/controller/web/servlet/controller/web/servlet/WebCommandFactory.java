package com.tradesystem.controller.web.servlet.controller.web.servlet;

import com.tradesystem.controller.web.servlet.command.common.WebCommand;
import com.tradesystem.repository.hibernate.HibernateCategoryRepository;
import com.tradesystem.repository.hibernate.HibernateProductRepository;
import com.tradesystem.service.category.DefaultCategoryService;
import com.tradesystem.service.product.DefaultProductService;

import java.util.HashMap;
import java.util.Map;

public class WebCommandFactory {

    public static Map<String, WebCommand> getPostCommands() {
        Map<String, WebCommand> postWebCommands = new HashMap<>();
        postWebCommands.put(WebCommandName.PRODUCT,
                new PostWebProductCommand(new DefaultProductService(new HibernateProductRepository()))
        );
        postWebCommands.put(WebCommandName.CATEGORY,
                new PostWebCategoryCommand(new DefaultCategoryService(new HibernateCategoryRepository()))
        );
        return postWebCommands;
    }

    public static Map<String, WebCommand> getGetCommands() {
        Map<String, WebCommand> getWebCommands = new HashMap<>();
        getWebCommands.put(WebCommandName.PRODUCT,
                new GetWebProductCommand(new DefaultProductService(new HibernateProductRepository()))
        );
        getWebCommands.put(WebCommandName.CATEGORY,
                new GetWebCategoryCommand(new DefaultCategoryService(new HibernateCategoryRepository()))
        );
        return getWebCommands;
    }
}