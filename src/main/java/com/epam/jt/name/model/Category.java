package com.epam.jt.name.model;

public class Category extends Entity {
    private static final long serialVersionUID = 4941626643361593417L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
