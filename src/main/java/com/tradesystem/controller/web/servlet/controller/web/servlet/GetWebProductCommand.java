package com.tradesystem.controller.web.servlet.controller.web.servlet;

import com.tradesystem.controller.web.servlet.command.common.GetWebCommand;
import com.tradesystem.controller.web.servlet.command.common.ViewName;
import com.tradesystem.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetWebProductCommand extends GetWebCommand {

    private final ProductService productService;

    public GetWebProductCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getName() {
        return WebCommandName.PRODUCT;
    }

    @Override
    public void execute(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.setAttribute("products", productService.findAll());
        forward(rq, rs, ViewName.PRODUCT);
    }
}