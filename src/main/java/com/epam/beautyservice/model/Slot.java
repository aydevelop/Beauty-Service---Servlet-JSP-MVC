package com.epam.beautyservice.model;

public class Slot extends Entity {
    private static final long serialVersionUID = 4941526643361593417L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Slot {" +
                "name='" + name + '\'' +
                '}';
    }
}
