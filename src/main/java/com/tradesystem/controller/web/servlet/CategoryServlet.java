package com.tradesystem.controller.web.servlet;

import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.model.Category;
import com.tradesystem.repository.category.CategoryRepository;
import com.tradesystem.repository.hibernate.HibernateCategoryRepository;
import com.tradesystem.service.category.CategoryService;
import com.tradesystem.service.category.InMemoryCategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new InMemoryCategoryService();
    private CategoryRepository repository = new HibernateCategoryRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  name = req.getParameter("name");
        Category category = Category.builder().name(name).build();
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(name);
        repository.save(categoryEntity);
        req.setAttribute("categories", categoryService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/category.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories",categoryService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/category.jsp");
        requestDispatcher.forward(req,resp);
    }
}
