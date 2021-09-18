package com.epam.beautyservice.controller.home.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Category;
import com.epam.beautyservice.model.Service;
import com.epam.beautyservice.model.User;
import com.epam.beautyservice.utils.Pagination;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeIndexGetAction extends Base implements Action {
    public HomeIndexGetAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() {
        List<Category> categories = db.getCategories().queryAll();
        request.setAttribute("categories", categories);

        List<User> masters = db.getUsers().queryAllWithRating();
        List<Service> services = db.getServices().queryAll();
        request.setAttribute("total", services.size());

        services = Pagination.Generation(request, services);
        request.setAttribute("services", services);
        request.setAttribute("masters", masters);

        view(view, request, response);
    }
}
