package com.epam.beautyservice.controller.auth;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.auth.action.*;
import com.epam.beautyservice.utils.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/auth/*")
public class AuthController extends HttpServlet {
    Action action = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());

        switch (path) {
            case "register":
                action = new AuthRegisterGetAction("auth/register", request, response);
                break;
            case "logout":
                action = new AuthLogoutGetAction(null, request, response);
                break;
            default:
                action = new AuthLoginGetAction("auth/login", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());

        switch (path) {
            case "login":
                action = new AuthLoginPostAction(null, request, response);
                break;
            case "register":
                action = new AuthRegisterPostAction(null, request, response);
                break;
            default:
                response.sendRedirect("/login");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        if (action != null) {
            action.execute();
        }
    }
}
