package com.epam.beautyservice.controller.auth.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

public class AuthLoginPostAction extends Base implements Action {
    public AuthLoginPostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = db.getUsers().findUserByEmail(email);

        if (user.getEmail() == null || !user.getPassword().equals(password)) {
            request.getSession().setAttribute("error", "Email address or password is incorrect ");
            redirect("/auth/login", request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            if (user.getLang() != null) {
                Config.set(session, "javax.servlet.jsp.jstl.fmt.locale", user.getLang());
                session.setAttribute("defaultLocale", user.getLang());
            }

            redirect("/home", request, response);
        }
    }
}
