package com.Models;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int userId;
    private int trackId;
    private Timestamp orderDate;
    private double totalPrice;
    
    public Order(int orderId, int userId, int trackId, Timestamp orderDate, double totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.trackId = trackId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
}
