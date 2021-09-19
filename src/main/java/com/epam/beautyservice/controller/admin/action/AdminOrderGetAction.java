package com.epam.beautyservice.controller.admin.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;
import com.epam.beautyservice.model.Slot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminOrderGetAction extends Base implements Action {
    public AdminOrderGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() {
        String id = request.getParameter("id");
        Order order = db.getOrders().findById(Long.parseLong(id));
        List<Slot> slots = db.getSlots().queryAll();

        request.setAttribute("slots", slots);
        request.setAttribute("order", order);

        view(view, request, response);
    }
}
