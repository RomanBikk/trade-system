package com.tradesystem.controller.web.servlet;

import com.tradesystem.model.Category;
import com.tradesystem.repository.category.CategoryRepository;
import com.tradesystem.service.category.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryController {
    private final CategoryService categoryService;
    private CategoryRepository repository;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  name = req.getParameter("name");
       categoryService.save(Category.builder().name(name).build());
        req.setAttribute("categories",categoryService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product.jsp");
        dispatcher.forward(req,resp);

    }


    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories",categoryService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/category.jsp");
        dispatcher.forward(req,resp);
    }

}
