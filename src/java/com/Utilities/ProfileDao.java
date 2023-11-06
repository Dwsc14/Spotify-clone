package com.Utilities;

import com.Models.Song;
import com.Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfileDao {
    private final DatabaseConnector db;
    private final UserDao userDao;
    
    public ProfileDao() throws Exception {
        db = new DatabaseConnector();
        userDao = new UserDao();
    }
    
    public List<Song> getSongofUser(String userID){
        List<Song> songs = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        try {
            myConn = db.getConnection();
            String sql = "SELECT songs.* FROM songs " +
                        "JOIN user ON songs.ArtistID = user.userId " +
                        "WHERE user.userId = ?";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, userID);

            rs = myStmt.executeQuery();

            while (rs.next()) {
                User user = userDao.getUserById(rs.getString("ArtistID"), true);
                Song song = new Song(rs.getInt("SongID"), rs.getString("Title"), user, rs.getString("FilePath"), rs.getString("ImagePath"));
                songs.add(song);
            }
            return songs;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return songs;
    }
    
    
    public static void main(String[] args) throws Exception {
        ProfileDao test = new ProfileDao();

        // Replace "YourUserName" with the actual username you want to search for
        String userID = "1698672041682-cb95e995-efa4-4b4f-96b8-de05c43a644f";

        try {
            List<Song> users = test.getSongofUser(userID);

            if (users.isEmpty()) {
                System.out.println("No users found with the username: " + userID);
            } else {
                System.out.println("Users found with the username: " + userID);
                for (Song user : users) {
                    System.out.println(user.getTitle() + ": " + user.getUser());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
