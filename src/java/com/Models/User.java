package com.Models;

public class User {
    private String userId;
    private String fullName;
    private String email;
    private String img;
    private String password;
    private String salt;

    public User() {
    }

    public User(String userId, String fullName, String email, String password, String salt, String img) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.img = img;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getImg() {
        return img;
    }
}
