package com.epam.beautyservice.controller.home.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

public class HomeLangChangeGetAction extends Base implements Action {
    public HomeLangChangeGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        String lang = request.getParameter("lang");
        HttpSession session = request.getSession();
        Config.set(session, Config.FMT_LOCALE, new java.util.Locale(lang));

        Config.set(session, "javax.servlet.jsp.jstl.fmt.locale", lang);
        session.setAttribute("defaultLocale", lang);

        Object user = session.getAttribute("user");
        if (user != null) {
            db.getUsers().editLang(((User) user).getId(), lang);
        }

        redirect("/home", request, response);
    }
}


