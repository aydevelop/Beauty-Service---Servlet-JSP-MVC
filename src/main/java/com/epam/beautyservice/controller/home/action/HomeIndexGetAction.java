package com.epam.beautyservice.controller.home.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.database.CategoryDao;
import com.epam.beautyservice.database.ServiceDao;
import com.epam.beautyservice.database.UserDao;
import com.epam.beautyservice.model.Category;
import com.epam.beautyservice.model.Service;
import com.epam.beautyservice.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeIndexGetAction implements Action {
    private final String view;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public HomeIndexGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        this.view = view;
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        List<Category> categories = new CategoryDao().queryAll();
        request.setAttribute("categories", categories);

        List<User> masters = new UserDao().queryMaster();
        request.setAttribute("masters", masters);

        List<Service> services = new ServiceDao().queryAll();
        request.setAttribute("services", services);

        view(view, request, response);
    }

}
