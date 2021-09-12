package com.epam.beautyservice.model;

public class Order extends Entity {
    private final long serialVersionUID = 2322302708945348585L;
    private String dataTime;
    private String status;
    private String feedbackText;
    private String feedbackRating;
    private int serviceId;
    private int clientId;
    private String category;

    private User client;
    private User master;
    private Service service;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public com.epam.beautyservice.model.User getClient() {
        return client;
    }

    public void setClient(com.epam.beautyservice.model.User client) {
        this.client = client;
    }

    public com.epam.beautyservice.model.User getMaster() {
        return master;
    }

    public void setMaster(com.epam.beautyservice.model.User master) {
        this.master = master;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(String feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
