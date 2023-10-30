package com.Models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String title;
    private List<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public Playlist(int id, String title, List<Song> songs) {
        this.id = id;
        this.title = title;
        this.songs = new ArrayList<>(songs);
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

    public List<Song> getSongs() {
        return new ArrayList<>(songs);
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", songs=" + songs +
                '}';
    }
}