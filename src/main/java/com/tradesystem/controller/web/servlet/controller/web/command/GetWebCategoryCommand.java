package com.tradesystem.controller.web.servlet.controller.web.command;

import com.tradesystem.controller.web.command.common.GetWebCommand;
import com.tradesystem.controller.web.command.common.ViewName;
import com.tradesystem.service.category.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetWebCategoryCommand extends GetWebCommand {

    private final CategoryService categoryService;

    public GetWebCategoryCommand(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Override
    public String getName() {
        return WebCommandName.CATEGORY;
    }

    @Override
    public void execute(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.setAttribute("categories", categoryService.findAll());
        forward(rq, rs, ViewName.CATEGORY);
    }
}
