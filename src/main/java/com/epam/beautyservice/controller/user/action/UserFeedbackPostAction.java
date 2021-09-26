package com.epam.beautyservice.controller.user.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;
import com.epam.beautyservice.utils.Security;
import com.epam.beautyservice.utils.Translate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserFeedbackPostAction extends Base implements Action {
    public UserFeedbackPostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String id = request.getParameter("id");
        String token = request.getParameter("token");
        String text = request.getParameter("feedback");
        String grade = request.getParameter("grade");

        Long lId = Long.parseLong(id);
        List<Order> orders = db.getOrders().queryAllWithUserServiceAndSlot();
        Optional<Order> order = orders.stream()
                .filter(ord -> ord.getId().toString().equals(id) && Security.getSHA512Password(ord.getClient().getEmail()).equals(token))
                .findFirst();

        if (order.isPresent()) {
            Order res = order.get();
            res.setFeedbackText(text);
            res.setFeedbackRating(grade);
            db.getOrders().edit(lId, res);
        }

        request.getSession().setAttribute("message", Translate.get("feedback_sent", request.getSession()));
        response.sendRedirect("/home");
    }
}
