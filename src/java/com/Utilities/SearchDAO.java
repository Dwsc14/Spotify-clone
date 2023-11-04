package com.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchDAO {
    private final DatabaseConnector db;
    private final UserDao userDao;
    private final PlaylistDao playlistDao;
    private final SongDao songDao;

    public SearchDAO() throws Exception {
        db = new DatabaseConnector();
        userDao = new UserDao();
        songDao = new SongDao();
        playlistDao = new PlaylistDao();
    }

    public int count(String txtSearch) {
        String sql = "SELECT COUNT(*)FROM songs WHERE Title LIKE ?";
        try (Connection myConn = db.getConnection();
                PreparedStatement myStmt = myConn.prepareStatement(sql)) {
            myStmt.setString(1, "%" + txtSearch + "%");
            try (ResultSet rs = myStmt.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<String> searchUser(String userName) throws Exception {
        List<String> resultUser = new ArrayList<>();
        String sql = "SELECT fullName FROM USER WHERE fullName LIKE ?";
        try (Connection myConn = db.getConnection();
                PreparedStatement myStmt = myConn.prepareStatement(sql)) {
            myStmt.setString(1, "%" + userName + "%");
            try (ResultSet rs = myStmt.executeQuery()) {
                while (rs.next()) {
                    String fullName = rs.getString("fullName");
                    resultUser.add(fullName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultUser;
    }

    public List<String> searchSong(String songTitle) throws Exception {
        List<String> resultSong = new ArrayList<>();
        String sql = "SELECT Title FROM Songs WHERE Title LIKE ?";
        try (Connection myConn = db.getConnection();
                PreparedStatement myStmt = myConn.prepareStatement(sql)) {
            myStmt.setString(1, "%" + songTitle + "%");
            try (ResultSet rs = myStmt.executeQuery()) {
                while (rs.next()) {
                    String title = rs.getString("Title");
                    resultSong.add(title);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSong;
    }

    public List<String> searchPlaylist(String plTitle) throws Exception {
        List<String> resultPlaylist = new ArrayList<>();
        String sql = "SELECT Title FROM playlists WHERE Title LIKE ?";
        try (Connection myConn = db.getConnection();
                PreparedStatement myStmt = myConn.prepareStatement(sql)) {
            myStmt.setString(1, "%" + plTitle + "%");
            try (ResultSet rs = myStmt.executeQuery()) {
                while (rs.next()) {
                    String playListTitle = rs.getString("Title");
                    resultPlaylist.add(playListTitle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultPlaylist;
    }

    public static void main(String[] args) throws Exception {
        try {
            SearchDAO dao = new SearchDAO();

            List<String> results = dao.searchUser("e");
            List<String> results1 = dao.searchSong("e");

            for (String name : results) {
                System.out.println(name);
            }

            for (String title : results1) {
                System.out.println(title);
            }

            List<String> results2 = dao.searchPlaylist("e");

            for (String playListTitle : results2) {
                System.out.println(playListTitle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}