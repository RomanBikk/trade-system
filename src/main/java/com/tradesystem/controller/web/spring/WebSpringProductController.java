package com.tradesystem.controller.web.spring;

import com.tradesystem.controller.rest.dto.ProductDto;
import com.tradesystem.converter.ProductConverter;
import com.tradesystem.model.Product;
import com.tradesystem.repository.hibernate.HibernateProductRepository;
import com.tradesystem.repository.product.ProductRepository;
import com.tradesystem.repository.spring.SpringCrudRepository;
import com.tradesystem.service.product.DefaultProductService;
import com.tradesystem.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("web/v2/product")
public class WebSpringProductController {

   private ProductService productService;

    public WebSpringProductController(ProductService springCrudRepository) {
        this.productService = springCrudRepository;
    }


    @GetMapping
    public String findAll(ModelMap model)
    {
        List<ProductDto> list= productService.findAll().stream()
                .map(ProductConverter::convertToProductDto)
                .collect(Collectors.toList());
                model.addAttribute("products", list);
        return "product";
    }

    @PostMapping
    public String save(@ModelAttribute("product") ProductDto product, Model model) {
        Product product1 = productService.save(ProductConverter.convertToProduct(product));
        model.addAttribute("product",product1);
        return "redirect:product";
    }



}


