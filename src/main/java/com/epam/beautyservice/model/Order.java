package com.epam.beautyservice.model;

public class Order extends Entity {
    private static final long serialVersionUID = 2322302708125348585L;
    private String date;
    private String status;
    private String feedbackText;
    private String feedbackRating;
    private Category category;

    private int clientId;
    private User client;
    private int masterId;
    private User master;
    private int serviceId;
    private int slotId;
    private Slot slot;

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    private Service service;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String dataTime) {
        this.date = dataTime;
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
