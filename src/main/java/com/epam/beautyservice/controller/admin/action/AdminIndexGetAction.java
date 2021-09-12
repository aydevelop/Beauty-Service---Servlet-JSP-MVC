package com.epam.beautyservice.controller.admin.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminIndexGetAction implements Action {
    private final String view;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public AdminIndexGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        this.view = view;
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        List<Order> orders = db.getOrders().queryAllWithUserService();
        request.setAttribute("orders", orders);
        view(view, request, response);
    }
}
