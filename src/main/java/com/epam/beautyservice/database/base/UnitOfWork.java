package com.epam.beautyservice.database.base;

import com.epam.beautyservice.database.*;

public class UnitOfWork {
    UserDao users;
    ServiceDao services;
    CategoryDao categories;
    OrderDao orders;
    SlotDao slots;

    private static UnitOfWork instance;

    public static synchronized UnitOfWork getInstance() {
        if (instance == null) {
            instance = new UnitOfWork();
        }
        return instance;
    }

    public synchronized UserDao getUsers() {
        if (users == null) {
            users = new UserDao();
        }
        return users;
    }

    public synchronized SlotDao getSlots() {
        if (slots == null) {
            slots = new SlotDao();
        }
        return slots;
    }

    public synchronized ServiceDao getServices() {
        if (services == null) {
            services = new ServiceDao();
        }
        return services;
    }

    public synchronized CategoryDao getCategories() {
        if (categories == null) {
            categories = new CategoryDao();
        }
        return categories;
    }

    public synchronized OrderDao getOrders() {
        if (orders == null) {
            orders = new OrderDao();
        }
        return orders;
    }
}
