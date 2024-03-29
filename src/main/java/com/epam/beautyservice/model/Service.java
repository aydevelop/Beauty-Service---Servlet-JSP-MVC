package com.epam.beautyservice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service extends Entity {
    private static final long serialVersionUID = 5692708766041842896L;
    private String name_ua;
    private String name_en;
    private double price;
    private String image;
    private String categoryId;
    private String masterIds;


    public List<String> getMasters() {
        List<String> arr = new ArrayList<>();
        if (masterIds != null) {
            arr = Arrays.asList(masterIds.split(","));
        }
        return arr;
    }

    public void setMasterIds(String masterIds) {
        this.masterIds = masterIds;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName(String defaultLocale) {
        if (defaultLocale.equals("ua")) {
            return name_ua;
        }
        return name_en;
    }
}