package com.epam.beautyservice.controller.home.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Category;
import com.epam.beautyservice.model.Service;
import com.epam.beautyservice.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

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

        //----------------------------------------------------------------------------
        int recordsPerPage = 3;
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        int nOfPages = services.size() / recordsPerPage;
        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        services = services.stream().skip((currentPage - 1) * recordsPerPage)
                .limit(recordsPerPage).collect(Collectors.toList());
        //----------------------------------------------------------------------------

        request.setAttribute("masters", masters);
        request.setAttribute("services", services);

        view(view, request, response);
    }
}
