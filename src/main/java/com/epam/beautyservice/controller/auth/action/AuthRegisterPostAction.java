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
import java.io.IOException;

public class AuthRegisterPostAction extends Base implements Action {
    public AuthRegisterPostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String firstName = request.getParameter("first-name").trim();
        String lastName = request.getParameter("last-name").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();

        HttpSession session = request.getSession();
        session.setAttribute("registerFirstName", firstName);
        session.setAttribute("registerLastName", lastName);
        session.setAttribute("registerEmail", email);

        Validator validator = new Validator(session);
        validator.checkEmail(email);
        validator.checkName(firstName);
        validator.checkName(lastName);
        validator.checkPassword(password);

        String error = validator.getError();
        if (error.length() > 0) {
            session.setAttribute("error", error);
            redirect("/auth/register", request, response);
            return;
        }

        User check = db.getUsers().findUserByEmail(email);
        if (check.getEmail() != null && check.getEmail().equals(email)) {
            session.setAttribute("error", "Email:" + email + " " + Translate.get("already_registered", request.getSession()));
            redirect("/auth/register", request, response);
            return;
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(Security.getSHA512Password(password));
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        db.getUsers().create(user);

        session.removeAttribute("registerFirstName");
        session.removeAttribute("registerLastName");
        session.removeAttribute("registerEmail");
        session.removeAttribute("message");
        redirect("/auth/login", request, response);
    }
}
