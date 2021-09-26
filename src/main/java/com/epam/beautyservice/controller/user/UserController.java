package com.epam.beautyservice.controller.user;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.user.action.UserFeedbackGetAction;
import com.epam.beautyservice.controller.user.action.UserFeedbackPostAction;
import com.epam.beautyservice.controller.user.action.UserOrderCreateGetAction;
import com.epam.beautyservice.controller.user.action.UserOrderCreatePostAction;
import com.epam.beautyservice.utils.Router;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Logic of work for a user with user roles
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
    private final Logger logger = Logger.getLogger(UserController.class);
    private Action action = null;

    /**
     * Mapping get requests
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = Router.parse(request.getPathInfo());
        logger.info(Router.format(path));

        switch (path) {
            case "order-create":
                logger.info("UserOrderCreateGetAction");
                action = new UserOrderCreateGetAction("user/order-create", request, response);
                break;
            case "order-feedback":
                logger.info("UserFeedbackGetAction");
                action = new UserFeedbackGetAction("user/feedback-create", request, response);
                break;
            default:
                logger.info("redirect /home");
                response.sendRedirect("/home");
        }
    }

    /**
     * Mapping post requests
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = Router.parse(request.getPathInfo());
        logger.info(Router.format(path));

        switch (path) {
            case "order-create":
                logger.info("UserOrderCreatePostAction");
                action = new UserOrderCreatePostAction(null, request, response);
                break;
            case "order-feedback":
                logger.info("UserFeedbackGetAction");
                action = new UserFeedbackPostAction(null, request, response);
                break;
            default:
                logger.info("redirect /home");
                response.sendRedirect("/home");
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
