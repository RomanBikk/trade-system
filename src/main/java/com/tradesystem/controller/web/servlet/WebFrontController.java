package com.tradesystem.controller.web.servlet;

import com.tradesystem.controller.web.TradeSystemUrls;
import com.tradesystem.controller.web.command.common.WebCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.tradesystem.controller.web.servlet.controller.web.command.WebCommandFactory.getGetCommands;
import static com.tradesystem.controller.web.servlet.controller.web.command.WebCommandFactory.getPostCommands;

@WebServlet(urlPatterns = "/"+ TradeSystemUrls.BASE + "/v1/*")
public class WebFrontController extends HttpServlet {
   private final static Map<String, WebCommand> postWebCommands = getPostCommands();
    private final static Map<String, WebCommand> getWebCommands = getGetCommands();
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        postWebCommands.get(rq.getRequestURI()).execute(rq, rs);
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        getWebCommands.get(rq.getRequestURI()).execute(rq, rs);
    }


}
