package com.epam.beautyservice.controller.user.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Service;
import com.epam.beautyservice.model.Slot;
import com.epam.beautyservice.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserOrderCreateGetAction extends Base implements Action {
    public UserOrderCreateGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String id = request.getParameter("id");
        Long lid = Long.parseLong(id);
        Service service = db.getServices().findById(lid);
        List<User> masters = db.getUsers().findAllByService(lid);
        List<Slot> slots = db.getSlots().queryAll();

        request.setAttribute("slots", slots);
        request.setAttribute("service", service);
        request.setAttribute("masters", masters);


        view(view, request, response);
    }
}
