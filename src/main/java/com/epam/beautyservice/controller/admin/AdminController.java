package com.epam.beautyservice.controller.admin;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.admin.action.HomeIndexGetAction;
import com.epam.beautyservice.utils.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());
        Action action = null;

        switch (path) {
            default:
                action = new HomeIndexGetAction("admin/index", request, response);
                break;
        }

        action.execute();
    }
}
