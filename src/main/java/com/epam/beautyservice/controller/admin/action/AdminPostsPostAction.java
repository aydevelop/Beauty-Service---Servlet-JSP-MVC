package com.epam.beautyservice.controller.admin.action;

import com.epam.beautyservice.controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminPostsPostAction implements Action {
    private final String view;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public AdminPostsPostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        this.view = view;
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() throws IOException {
        String statusOrder = request.getParameter("status");
        String idOrder = request.getParameter("id");

        response.sendRedirect("/admin");
    }
}
