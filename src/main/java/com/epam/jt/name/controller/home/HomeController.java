package com.epam.jt.name.controller.home;

import com.epam.jt.name.database.dao.CategoryDao;
import com.epam.jt.name.database.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg;

        List<Category> list = new CategoryDao().findAll();
        msg = (list.toString());

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Category</h1>");
        out.write("<hr/>");
        out.write("<p>" + msg + "</p>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
