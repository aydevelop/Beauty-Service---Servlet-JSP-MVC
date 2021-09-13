package com.epam.beautyservice.controller.user.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserOrderCreatePostAction extends Base implements Action {

    public UserOrderCreatePostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String id = request.getParameter("id");
        String datetime = request.getParameter("datetime");

        Order order = new Order();
        order.setClientId(1);
        order.setServiceId(Integer.parseInt(id));
        order.setMasterId(1);
        order.setDataTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        db.getOrders().create(order);
        response.sendRedirect("/home");
    }
}
