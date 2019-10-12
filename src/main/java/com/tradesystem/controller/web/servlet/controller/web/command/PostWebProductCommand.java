package com.tradesystem.controller.web.servlet.controller.web.command;

import com.tradesystem.controller.web.command.common.PostWebCommand;
import com.tradesystem.model.Category;
import com.tradesystem.model.Product;
import com.tradesystem.service.product.ProductService;
import org.apache.commons.lang3.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

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
        productService.save(convertToProduct(rq));
        redirect(rq,rs);
    }

    private Product convertToProduct(HttpServletRequest rq) {
        String name = rq.getParameter("name");
        String description = rq.getParameter("description");
        Category category = Optional.ofNullable(rq.getParameter("categoryId"))
                .filter(ObjectUtils::isNotEmpty)
                .map(Long::valueOf)
                .map(this::createCategory)
                .orElse(null);
        return Product.builder()
                .name(name)
                .description(description)
                .category(category)
                .build();


    }

    private Category createCategory(Long categoryId) {
        return Category.builder().id(categoryId).build();
    }
}
