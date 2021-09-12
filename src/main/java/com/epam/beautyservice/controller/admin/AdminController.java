package com.epam.beautyservice.controller.admin;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.admin.action.AdminIndexGetAction;
import com.epam.beautyservice.controller.admin.action.AdminOrderGetAction;
import com.epam.beautyservice.controller.admin.action.AdminPostsPostAction;
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
            case "order":
                action = new AdminOrderGetAction("admin/order", request, response);
                break;
            default:
                action = new AdminIndexGetAction("admin/orders", request, response);
                break;
        }

        action.execute();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());
        Action action = null;

        switch (path) {
            case "orders":
                action = new AdminPostsPostAction(null, request, response);
                break;
            default:
                response.sendRedirect("/admin");
        }

        if (action != null) {
            action.execute();
        }
    }
}
