package com.epam.beautyservice.controller.user.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;
import com.epam.beautyservice.model.User;

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
        String idService = request.getParameter("service-id");
        String idMaster = request.getParameter("master-id");
        //String datetime = request.getParameter("datetime");

        User user = (User) request.getSession().getAttribute("user");
        long id = user.getId();

        Order order = new Order();
        order.setClientId((int) id);
        order.setServiceId(Integer.parseInt(idService));
        order.setMasterId(Integer.parseInt(idMaster));
        order.setDataTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        db.getOrders().create(order);

        request.getSession().setAttribute("message", "The service with the id " + idService + " is taken");
        response.sendRedirect("/home");
    }
}