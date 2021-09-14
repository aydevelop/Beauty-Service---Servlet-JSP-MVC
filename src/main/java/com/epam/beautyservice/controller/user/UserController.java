package com.epam.beautyservice.controller.user;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.user.action.UserOrderCreateGetAction;
import com.epam.beautyservice.controller.user.action.UserOrderCreatePostAction;
import com.epam.beautyservice.utils.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
    Action action = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());

        switch (path) {
            case "order-create":
                action = new UserOrderCreateGetAction("user/order-create", request, response);
                break;
            default:
                response.sendRedirect("/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());

        switch (path) {
            case "order-create":
                action = new UserOrderCreatePostAction(null, request, response);
                break;
            default:
                response.sendRedirect("/home");
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
