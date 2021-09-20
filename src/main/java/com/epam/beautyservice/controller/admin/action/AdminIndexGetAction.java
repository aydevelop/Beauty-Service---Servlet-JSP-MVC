package com.epam.beautyservice.controller.admin.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminIndexGetAction extends Base implements Action {
    public AdminIndexGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() {
        List<Order> orders = db.getOrders().queryAllWithUserServiceAndSlot();
        request.setAttribute("orders", orders);
        view(view, request, response);
    }
}
