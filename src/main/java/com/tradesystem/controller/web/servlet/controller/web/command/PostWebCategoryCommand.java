package com.tradesystem.controller.web.servlet.controller.web.command;

import com.tradesystem.controller.web.command.common.PostWebCommand;
import com.tradesystem.controller.web.command.common.ViewName;
import com.tradesystem.model.Category;
import com.tradesystem.service.category.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostWebCategoryCommand extends PostWebCommand {
    private final CategoryService categoryService;

    public PostWebCategoryCommand(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public String getName() {
        return WebCommandName.CATEGORY;
    }

    @Override
    public void execute(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String  name = rq.getParameter("name");
        categoryService.save(Category.builder().name(name).build());
        RequestDispatcher dispatcher = rq.getRequestDispatcher(ViewName.CATEGORY);
        rs.sendRedirect(rq.getContextPath()+ WebCommandName.CATEGORY);

    }
}
