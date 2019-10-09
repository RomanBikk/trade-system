package com.tradesystem.controller.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tradesystem.model.Category;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductDto {
    public Long id;
    public String name;
    public String description;
    public Long categoryId;
    Category category;
}
