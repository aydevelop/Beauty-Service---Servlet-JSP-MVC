package com.epam.beautyservice.controller.admin.action;

import com.epam.beautyservice.controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminOrderGetAction implements Action {
    private final String view;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public AdminOrderGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        this.view = view;
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String id = request.getParameter("id");
        //Order order = db.getOrders().findById(Long.parseLong(id));

        view(view, request, response);
    }
}
