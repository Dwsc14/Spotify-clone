package com.Models;

import java.sql.Timestamp;

public class MusicTrack {
    private int trackId;
    private String title;
    private int artistId;
    private String description;
    private String genre;
    private String audioUrl;
    private double price;
    private Timestamp createdAt;
    
    public MusicTrack(int trackId, String title, int artistId, String description, String genre, String audioUrl,
            double price, Timestamp createdAt) {
        this.trackId = trackId;
        this.title = title;
        this.artistId = artistId;
        this.description = description;
        this.genre = genre;
        this.audioUrl = audioUrl;
        this.price = price;
        this.createdAt = createdAt;
    }
    public int getTrackId() {
        return trackId;
    }
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAudioUrl() {
        return audioUrl;
    }
    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    
    
}
