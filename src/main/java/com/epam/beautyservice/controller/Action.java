package com.epam.beautyservice.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    Logger logger = Logger.getLogger(Action.class);

    void execute() throws IOException;

    default void view(String file, HttpServletRequest req, HttpServletResponse res) {
        String path = "/WEB-INF/view/" + file + ".jsp";

        try {
            logger.info("forward view " + path);
            req.getRequestDispatcher(path).forward(req, res);
        } catch (ServletException | IOException ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    default void fragment(String file, HttpServletRequest req, HttpServletResponse res) {
        String path = "/WEB-INF/fragment/" + file + ".jsp";

        try {
            logger.info("forward fragment " + path);
            req.getRequestDispatcher(path).forward(req, res);
        } catch (ServletException | IOException ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    default void redirect(String file, HttpServletRequest req, HttpServletResponse res) {
        try {
            logger.error("redirect " + file);
            res.sendRedirect(file);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
