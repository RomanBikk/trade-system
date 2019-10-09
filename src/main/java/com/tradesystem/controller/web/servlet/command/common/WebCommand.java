package com.tradesystem.controller.web.servlet.command.common;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface WebCommand {
        String getName();
        void execute(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException;
    }

