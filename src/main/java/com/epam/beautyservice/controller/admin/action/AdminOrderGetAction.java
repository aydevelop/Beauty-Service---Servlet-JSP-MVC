package com.epam.beautyservice.controller.admin.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminOrderGetAction extends Base implements Action {
    public AdminOrderGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() {
        String id = request.getParameter("id");
        Order order = db.getOrders().findById(Long.parseLong(id));
        request.setAttribute("order", order);
        view(view, request, response);
    }
}
