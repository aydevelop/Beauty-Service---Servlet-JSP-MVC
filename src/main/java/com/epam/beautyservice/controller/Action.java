package com.epam.beautyservice.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    void execute() throws IOException;

    
    default void view(String file, HttpServletRequest req, HttpServletResponse res) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/" + file + ".jsp");

        try {
            dispatcher.forward(req, res);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    default void redirect(String file, HttpServletRequest req, HttpServletResponse res) {
        try {
            res.sendRedirect(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
