package com.epam.jt.name.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    public static void view(String file, HttpServletRequest req, HttpServletResponse res) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/" + file + ".jsp");

        try {
            dispatcher.forward(req, res);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void redirect(String file, HttpServletRequest req, HttpServletResponse res) {
        try {
            res.sendRedirect(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String path(HttpServletRequest req) {
        String result = req.getPathInfo();
        if (result == null)
            result = "";

        result = result.replaceAll("(^/)|(/$)", "");
        return result;
    }
}
