package com.tradesystem.controller.web.servlet.command.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class PostWebCommand implements WebCommand {

    protected void redirect(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
        String location = servletRequest.getContextPath() + getName();
        servletResponse.sendRedirect(location);
    }
}