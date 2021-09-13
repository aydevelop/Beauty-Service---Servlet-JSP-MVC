package com.epam.beautyservice.controller.master.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MasterOrderDonePostAction extends Base implements Action {

    public MasterOrderDonePostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String id = request.getParameter("id");
        Long idl = Long.parseLong(id);
        Order order = db.getOrders().findById(idl);
        order.setStatus("is_done");
        db.getOrders().edit(idl, order);
        request.getSession().setAttribute("message", "The order with the id " + id + " is executed ");
        response.sendRedirect("/master");
    }
}
