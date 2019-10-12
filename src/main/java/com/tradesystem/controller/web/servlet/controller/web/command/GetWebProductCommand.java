package com.tradesystem.controller.web.servlet.controller.web.command;

import com.tradesystem.controller.web.command.common.GetWebCommand;
import com.tradesystem.controller.web.command.common.ViewName;
import com.tradesystem.converter.ProductConverter;
import com.tradesystem.service.category.CategoryService;
import com.tradesystem.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class GetWebProductCommand extends GetWebCommand {

    private final ProductService productService;
    private final CategoryService categoryService;

    public GetWebProductCommand(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public String getName() {
        return WebCommandName.PRODUCT;
    }

    @Override
    public void execute(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.setAttribute("products", productService.findAll().stream().map(ProductConverter::convertToProductDto).collect(Collectors.toList()));
        rq.setAttribute("categories", categoryService.findAll());
        forward(rq, rs, ViewName.PRODUCT);
    }
}