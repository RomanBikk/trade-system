package com.tradesystem.controller.web.servlet.controller.web.servlet;

import com.tradesystem.controller.web.servlet.command.common.PostWebCommand;
import com.tradesystem.controller.web.servlet.command.common.ViewName;
import com.tradesystem.controller.web.servlet.command.common.WebCommand;
import com.tradesystem.model.Product;
import com.tradesystem.service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostWebProductCommand extends PostWebCommand {

    private final ProductService productService;

    public PostWebProductCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getName() {
        return WebCommandName.PRODUCT;
    }

    @Override
    public void execute(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String  name = rq.getParameter("name");
        String description = rq.getParameter("description");
        productService.save(Product.builder().name(name).description(description).build());
        RequestDispatcher dispatcher = rq.getRequestDispatcher(ViewName.PRODUCT);
        rs.sendRedirect(rq.getContextPath()+ WebCommandName.PRODUCT);
    }
}
