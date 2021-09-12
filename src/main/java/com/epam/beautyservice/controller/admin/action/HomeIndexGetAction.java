package com.epam.beautyservice.controller.admin.action;

import com.epam.beautyservice.controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        view(view, request, response);
    }
}
