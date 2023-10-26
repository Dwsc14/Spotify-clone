package com.Models;

public class ArtistModel {
    private int artistId;
    private String name;
    private String bio;
    private String imageUrl;

    public ArtistModel(int artistId, String name, String bio, String imageUrl) {
        this.artistId = artistId;
        this.name = name;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    
}
