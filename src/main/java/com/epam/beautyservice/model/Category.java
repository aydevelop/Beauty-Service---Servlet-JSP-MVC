package com.epam.beautyservice.model;

public class Category extends Entity {
    private static final long serialVersionUID = 4941626643361593417L;
    private String name_ua;

    public String getName_ua() {
        return name_ua;
    }

    public void setName_ua(String name_ua) {
        this.name_ua = name_ua;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    private String name_en;

    public String getName(String defaultLocale) {
        if (defaultLocale.equals("ua")) {
            return name_ua;
        }
        return name_en;
    }
}
