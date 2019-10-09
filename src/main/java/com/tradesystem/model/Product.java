package com.tradesystem.model;

import lombok.*;

import javax.servlet.annotation.WebServlet;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private Category category;
}
