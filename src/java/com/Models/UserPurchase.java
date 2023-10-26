package com.Models;

import java.sql.Timestamp;

public class UserPurchase {
    private int purchaseId;
    private int userId;
    private int trackId;
    private Timestamp purchaseDate;

    public UserPurchase(int purchaseId, int userId, int trackId, Timestamp purchaseDate) {
        this.purchaseId = purchaseId;
        this.userId = userId;
        this.trackId = trackId;
        this.purchaseDate = purchaseDate;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
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

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    
}
