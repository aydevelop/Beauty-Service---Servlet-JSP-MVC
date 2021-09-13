package com.epam.beautyservice.controller;

import com.epam.beautyservice.database.base.UnitOfWork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Base {
    protected UnitOfWork db = UnitOfWork.getInstance();
    protected final String view;
    protected final HttpServletRequest request;
    protected final HttpServletResponse response;


    protected Base(String view, HttpServletRequest request, HttpServletResponse response) {
        this.view = view;
        this.request = request;
        this.response = response;
    }
}
