package com.epam.beautyservice.controller.user.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFeedbackGetAction extends Base implements Action {
    public UserFeedbackGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String id = request.getParameter("id");
        String token = request.getParameter("token");
        request.setAttribute("id", id);
        request.setAttribute("token", token);

        view(view, request, response);
    }
}
