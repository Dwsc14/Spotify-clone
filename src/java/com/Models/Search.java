package com.Models;

public class Search {
    private String title;
    private User user;
    private String ImagePath;

    public Search() {
    }

    public Search(String title, User user, String ImagePath) {
        this.title = title;
        this.user = user;
        this.ImagePath = ImagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String ImagePath) {
        this.ImagePath = ImagePath;
    }

    @Override
    public String toString() {
        return "InfoPlaylist{" + "title=" + title + ", userId=" + user + ", ImagePath=" + ImagePath + '}';
    }

}

