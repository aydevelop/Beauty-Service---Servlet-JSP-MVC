package com.epam.beautyservice.model;

public class Service extends Entity {
    private static final long serialVersionUID = 5692708766041842896L;
    private String name_ua;
    private String name_en;
    private double price;
    private String image;
    private String description_ua;
    private String description_en;
    private int categoryId;

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

    public String getDescription_ua() {
        return description_ua;
    }

    public void setDescription_ua(String description_ua) {
        this.description_ua = description_ua;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}