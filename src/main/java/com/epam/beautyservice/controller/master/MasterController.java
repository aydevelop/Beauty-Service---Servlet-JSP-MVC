package com.epam.beautyservice.controller.master;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.master.action.MasterIndexGetAction;
import com.epam.beautyservice.controller.master.action.MasterOrderDonePostAction;
import com.epam.beautyservice.utils.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/master/*")
public class MasterController extends HttpServlet {
    Action action = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());

        switch (path) {
            default:
                action = new MasterIndexGetAction("master/index", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Router.parse(request.getPathInfo());

        switch (path) {
            case "order-done":
                action = new MasterOrderDonePostAction(null, request, response);
                break;
            default:
                response.sendRedirect("/master");
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
