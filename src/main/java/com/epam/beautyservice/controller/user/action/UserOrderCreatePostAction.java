package com.epam.beautyservice.controller.user.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;
import com.epam.beautyservice.model.User;
import com.epam.beautyservice.utils.Validator;

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
        String idSlot = request.getParameter("slot-id");
        String date = request.getParameter("date");

        if(!Validator.isDateValid(date)){
            request.getSession().setAttribute("error", "The date is not valid");
            response.sendRedirect("/home");
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        long id = user.getId();

        Order order = new Order();
        order.setClientId((int) id);
        order.setServiceId(Integer.parseInt(idService));
        order.setMasterId(Integer.parseInt(idMaster));
        order.setDate(date);
        order.setSlotId(Integer.parseInt(idSlot));
        db.getOrders().create(order);

        request.getSession().setAttribute("message", "The service with the id " + idService + " is taken");
        response.sendRedirect("/home");
    }
}
