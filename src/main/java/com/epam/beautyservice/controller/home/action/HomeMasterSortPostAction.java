package com.epam.beautyservice.controller.home.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HomeMasterSortPostAction extends Base implements Action {
    public HomeMasterSortPostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() {
        List<User> masters = db.getUsers().queryAllWithRating();
        String by = request.getParameter("by");

        if (by != null) {
            switch (by) {
                case "first_name":
                    masters = masters.stream().sorted(Comparator.comparing(User::getFirst_name))
                            .collect(Collectors.toList());
                    break;
                case "last_name":
                    masters = masters.stream().sorted(Comparator.comparing(User::getLast_name))
                            .collect(Collectors.toList());
                    break;
            }
        }

        request.setAttribute("masters", masters);
        fragment("masters", request, response);
    }
}