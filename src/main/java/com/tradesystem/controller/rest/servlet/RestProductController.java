package com.tradesystem.controller.rest.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradesystem.controller.rest.dto.ProductDto;
import com.tradesystem.model.Product;
import com.tradesystem.service.product.ProductService;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class RestProductController {
    private final ProductService productService;

    public RestProductController(ProductService productService) {
        this.productService = productService;
    }


    public void findAll(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        rs.getWriter().append(mapper.writeValueAsString(
                productService.findAll()
                        .stream()
                        .map(this::convertToProductDto)
                        .collect(Collectors.toList())
        ));
        rs.setHeader("Content-Type", "application/json");
    }

    public void save(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        BufferedReader reader = rq.getReader();
        ObjectMapper mapper = new ObjectMapper();
        String request = IOUtils.toString(reader);
        if (!request.trim().isEmpty()) {
            Product productToSave = mapper.readValue(request, Product.class);
            Product savedProduct = productService.save(productToSave);
            rs.getWriter().append(mapper.writeValueAsString(convertToProductDto(savedProduct)));
            rs.setHeader("Content-Type", "application/json");
            rs.setStatus(201);
        } else {
            rs.setStatus(406);
        }
    }

    private ProductDto convertToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .categoryId(product.getCategoryId())
                .build();
    }

}
