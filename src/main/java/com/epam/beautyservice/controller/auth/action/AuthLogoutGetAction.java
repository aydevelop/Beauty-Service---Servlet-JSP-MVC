package com.epam.beautyservice.controller.auth.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthLogoutGetAction extends Base implements Action {
    public AuthLogoutGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        redirect("/home", request, response);
    }
}
