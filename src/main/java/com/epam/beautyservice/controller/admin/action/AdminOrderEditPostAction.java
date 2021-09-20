package com.epam.beautyservice.controller.admin.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminOrderEditPostAction extends Base implements Action {
    public AdminOrderEditPostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String status = request.getParameter("status");
        String slotId = request.getParameter("slot-id");
        String id = request.getParameter("id");

        Order order = db.getOrders().findById(Long.parseLong(id));
        order.setStatus(status);
        order.setSlotId(Integer.parseInt(slotId));
        db.getOrders().edit(Long.parseLong(id), order);

        response.sendRedirect("/admin");
    }
}
