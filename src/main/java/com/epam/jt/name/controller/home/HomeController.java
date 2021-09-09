package com.epam.jt.name.controller.home;

import com.epam.jt.name.controller.Controller;
import com.epam.jt.name.database.CategoryDao;
import com.epam.jt.name.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home/*")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Controller.path(request);

        String msg;
        List<Category> list = new CategoryDao().queryAll();
        msg = (list.toString());
//
//        PrintWriter out = response.getWriter();
//        out.write("<h1>Category</h1>");
//        out.write("<hr/>");
//        out.write("<p>" + msg + "</p>");
//        out.close();

        Controller.view("home/index", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
