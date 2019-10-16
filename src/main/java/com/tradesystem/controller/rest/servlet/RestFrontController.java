package com.tradesystem.controller.rest.servlet;

import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.model.Category;
import com.tradesystem.repository.hibernate.HibernateProductRepository;
import com.tradesystem.service.product.DefaultProductService;
import com.tradesystem.util.TradeSystemUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/rest/v1/*")
public class RestFrontController extends HttpServlet {
    RestProductController productController = new RestProductController(new DefaultProductService(new HibernateProductRepository()));


    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse resp) throws ServletException, IOException {
        switch (TradeSystemUtil.getPath(rq)) {
            case RestTradeSystemUrl.PRODUCT:
                productController.save(rq, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        switch (TradeSystemUtil.getPath(rq)) {
            case RestTradeSystemUrl.PRODUCT:
                productController.findAll(rq, rs);
        }
    }
}
