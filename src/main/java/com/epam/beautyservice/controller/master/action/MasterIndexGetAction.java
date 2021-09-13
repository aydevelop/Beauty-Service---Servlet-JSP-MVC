package com.epam.beautyservice.controller.master.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MasterIndexGetAction extends Base implements Action {
    public MasterIndexGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        List<Order> orders = db.getOrders().queryAllWithUserService();
        List<Order> orders2 = orders.stream()
                .filter(x -> x.getStatus().equals("is_canceled") == false).collect(Collectors.toList());
        request.setAttribute("orders", orders2);
        view(view, request, response);
    }
}
