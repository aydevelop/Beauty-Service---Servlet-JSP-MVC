package com.epam.beautyservice.controller.admin;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.admin.action.AdminIndexGetAction;
import com.epam.beautyservice.controller.admin.action.AdminOrderEditGetAction;
import com.epam.beautyservice.controller.admin.action.AdminOrderEditPostAction;
import com.epam.beautyservice.utils.Router;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/*")
public class AdminController extends HttpServlet {
    private final Logger logger = Logger.getLogger(AdminController.class);
    private Action action = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String path = Router.parse(request.getPathInfo());
        logger.info(Router.format(path));

        switch (path) {
            case "order-edit":
                logger.info("AdminOrderEditGetAction");
                action = new AdminOrderEditGetAction("admin/order-edit", request, response);
                break;
            default:
                logger.info("AdminIndexGetAction");
                action = new AdminIndexGetAction("admin/orders", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = Router.parse(request.getPathInfo());
        logger.info(Router.format(path));
        
        switch (path) {
            case "order-edit":
                logger.info("AdminOrderEditPostAction");
                action = new AdminOrderEditPostAction(null, request, response);
                break;
            default:
                logger.info("redirect /admin");
                response.sendRedirect("/admin");
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
