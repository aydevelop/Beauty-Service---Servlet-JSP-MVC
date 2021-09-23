package com.epam.beautyservice.controller.user.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFeedbackPostAction extends Base implements Action {
    public UserFeedbackPostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String id = request.getParameter("id");
        String text = request.getParameter("feedback");
        String grade = request.getParameter("grade");

        Long lId = Long.parseLong(id);
        Order order = db.getOrders().findById(lId);
        order.setFeedbackText(text);
        order.setFeedbackRating(grade);
        db.getOrders().edit(lId, order);

        request.getSession().setAttribute("message", "Feedback sent");
        response.sendRedirect("/home");
    }
}
