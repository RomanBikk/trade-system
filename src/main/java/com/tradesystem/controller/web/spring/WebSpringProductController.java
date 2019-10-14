package com.tradesystem.controller.web.spring;

import com.tradesystem.model.Product;
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
import java.util.List;


@Controller
@RequestMapping("/product")
public class WebSpringProductController extends AbstractController  {

    private final Logger logger = LoggerFactory.getLogger(WebSpringProductController.class);

   private SpringCrudRepository springCrudRepository;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("product");
        model.addObject("products", springCrudRepository.findAll());
        return model;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String ListProducts(ModelMap model)
    {
        List<Product> list= (List<Product>) springCrudRepository.findAll();
        model.addAttribute("products", list);
        return "product";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        springCrudRepository.save(product);

        return "redirect:/product";
    }



}


