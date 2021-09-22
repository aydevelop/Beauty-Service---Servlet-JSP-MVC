package com.epam.beautyservice.controller.auth;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.auth.action.*;
import com.epam.beautyservice.utils.Router;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/*")
public class AuthController extends HttpServlet {
    private final Logger logger = Logger.getLogger(AuthController.class);
    private Action action = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String path = Router.parse(request.getPathInfo());
        logger.info(Router.format(path));

        switch (path) {
            case "register":
                logger.info("AuthRegisterGetAction");
                action = new AuthRegisterGetAction("auth/register", request, response);
                break;
            case "logout":
                logger.info("AuthLogoutGetAction");
                action = new AuthLogoutGetAction(null, request, response);
                break;
            default:
                logger.info("AuthLoginGetAction");
                action = new AuthLoginGetAction("auth/login", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = Router.parse(request.getPathInfo());
        logger.info(Router.format(path));

        switch (path) {
            case "login":
                logger.info("AuthLoginPostAction");
                action = new AuthLoginPostAction(null, request, response);
                break;
            case "register":
                logger.info("AuthRegisterPostAction");
                action = new AuthRegisterPostAction(null, request, response);
                break;
            default:
                logger.info("redirect /login");
                response.sendRedirect("/login");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        if (action != null) {
            action.execute();
            logger.info("executed");
        }
    }
}
