package com.Models;

public class Song {
    private int id;
    private String title;
    private User user;
    private String src;
    private String imagePath;

    public Song() {
    }

    public Song(int id, String title, User user, String src, String imagePath) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.src = src;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", src='" + src + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
