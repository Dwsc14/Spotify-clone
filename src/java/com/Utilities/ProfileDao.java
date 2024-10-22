package com.Utilities;

import com.Models.Search;
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
    
    public List<Search> getPlayListofUser(String userID){
        List<Search> pls = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        try {
            myConn = db.getConnection();
            String sql = "SELECT playlists.* FROM playlists " +
                        "JOIN user ON playlists.UserID = user.userId " +
                        "WHERE user.userId = ?";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, userID);

            rs = myStmt.executeQuery();

            while (rs.next()) {
                User user = userDao.getUserById(rs.getString("UserID"), true);
                Search plws = new Search(rs.getString("Title"),user,rs.getString("image_path"));
                pls.add(plws);
            }
            return pls;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return pls;
    }

}
