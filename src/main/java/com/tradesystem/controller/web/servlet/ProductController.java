package com.tradesystem.controller.web.servlet;

import com.tradesystem.controller.web.TradeSystemUrls;
import com.tradesystem.model.Product;
import com.tradesystem.repository.product.ProductRepository;
import com.tradesystem.service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController {
    private ProductService productService;
    private ProductRepository repository;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  name = req.getParameter("name");
        String description = req.getParameter("description");
        productService.save(Product.builder().name(name).description(description).build());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product.jsp");
       resp.sendRedirect(req.getContextPath()+ "/" + TradeSystemUrls.BASE+ "/" + TradeSystemUrls.PRODUCT);

    }


    public void findAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products",productService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product.jsp");
        dispatcher.forward(req,resp);
    }


}
