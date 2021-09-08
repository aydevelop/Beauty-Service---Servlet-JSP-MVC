package com.epam.jt.name.database.entity;

public class ServiceCategory extends Entity {
    private static final long serialVersionUID = 5692744766041889396L;
    private int serviceId;
    private int categoryId;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
