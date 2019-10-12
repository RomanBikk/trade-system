package com.tradesystem.controller.web.spring;

import com.tradesystem.model.Product;
import com.tradesystem.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("spring/product")

public class WebSpringProductController {

    private final Logger logger = LoggerFactory.getLogger(WebSpringProductController.class);

    public WebSpringProductController() {
    }

    private ProductService productService;



    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model) {
        logger.debug("showAll()");
        model.addAttribute("products", productService.findAll());
        return "product";

    }

    /*@RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute("userForm") @Validated Product product,BindingResult result, Model model,
                       final RedirectAttributes redirectAttributes) {
        logger.debug("save() : {}", product);
            productService.save(product);
            return "redirect:/users/" + product.getId();
    }

     */
}


