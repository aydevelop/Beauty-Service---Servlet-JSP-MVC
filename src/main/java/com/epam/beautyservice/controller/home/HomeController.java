package com.epam.beautyservice.controller.home;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.home.action.HomeIndexGetAction;
import com.epam.beautyservice.controller.home.action.HomeLangChangeGetAction;
import com.epam.beautyservice.controller.home.action.HomeMasterSortPostAction;
import com.epam.beautyservice.controller.home.action.HomeServiceSortPostAction;
import com.epam.beautyservice.utils.Router;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Main page logic
 */
@WebServlet(value = "/home/*")
public class HomeController extends HttpServlet {
    private final Logger logger = Logger.getLogger(HomeController.class);
    private Action action = null;

    /**
     * Mapping get requests
     *
     * @param request
     * @param response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String path = Router.parse(request.getPathInfo());
        logger.info(Router.format(path));

        switch (path) {
            case "lang-change":
                logger.info("HomeLangChangeGetAction");
                action = new HomeLangChangeGetAction(null, request, response);
                break;

            default:
                logger.info("HomeIndexGetAction");
                action = new HomeIndexGetAction("home/index", request, response);
                break;
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
            case "master-sort":
                logger.info("HomeMasterSortPostAction");
                action = new HomeMasterSortPostAction(null, request, response);
                break;
            case "service-sort":
                logger.info("HomeServiceSortPostAction");
                action = new HomeServiceSortPostAction(null, request, response);
                break;
            default:
                logger.info("redirect /home");
                response.sendRedirect("/home");
                break;
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
