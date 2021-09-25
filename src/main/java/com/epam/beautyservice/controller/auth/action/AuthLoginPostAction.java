package com.epam.beautyservice.controller.auth.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.User;
import com.epam.beautyservice.utils.Security;
import com.epam.beautyservice.utils.Translate;
import com.epam.beautyservice.utils.Validator;

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
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();

        User user = db.getUsers().findUserByEmail(email);
        HttpSession session = request.getSession();
        session.setAttribute("loginEmail", email);
        session.setAttribute("loginPassword", password);

        Validator validator = new Validator(session);
        validator.checkEmail(email);
        validator.checkPassword(password);

        String error = validator.getError();
        if (error.length() > 0) {
            session.setAttribute("error", error);
            redirect("/auth/login", request, response);
            return;
        }

        String hash = Security.getSHA512Password(password);
        if (user.getEmail() == null || !user.getPassword().equals(hash)) {
            session.setAttribute("error", Translate.get("password_is_incorrect", request.getSession()));
            redirect("/auth/login", request, response);
            return;
        }

        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        if (user.getLang() != null) {
            Config.set(session, "javax.servlet.jsp.jstl.fmt.locale", user.getLang());
            session.setAttribute("defaultLocale", user.getLang());
        }

        redirect("/home", request, response);
    }
}
