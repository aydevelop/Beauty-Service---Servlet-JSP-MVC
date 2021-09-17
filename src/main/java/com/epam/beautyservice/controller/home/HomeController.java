package com.epam.beautyservice.controller.home;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.home.action.HomeIndexGetAction;
import com.epam.beautyservice.controller.home.action.HomeLangChangeGetAction;
import com.epam.beautyservice.controller.home.action.HomeMasterSortPostAction;
import com.epam.beautyservice.controller.home.action.HomeServiceSortPostAction;
import com.epam.beautyservice.utils.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/home/*")
public class HomeController extends HttpServlet {
    Action action = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());

        switch (path) {
            case "lang-change":
                action = new HomeLangChangeGetAction(null, request, response);
                break;

            default:
                action = new HomeIndexGetAction("home/index", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());

        switch (path) {
            case "master-sort":
                action = new HomeMasterSortPostAction(null, request, response);
                break;
            case "service-sort":
                action = new HomeServiceSortPostAction(null, request, response);
                break;
            default:
                response.sendRedirect("/home");
                break;
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
