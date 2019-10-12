package com.tradesystem.controller.web.command.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class GetWebCommand implements WebCommand {

    protected void forward(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String view) throws ServletException, IOException {
        String path = String.format("/WEB-INF/%s.jsp", view);
        RequestDispatcher rd = servletRequest.getRequestDispatcher(path);
        rd.forward(servletRequest, servletResponse);
    }
}