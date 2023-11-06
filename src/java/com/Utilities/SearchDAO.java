package com.Utilities;

import com.Models.Search;
import com.Models.Song;
import com.Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDao {
    private final DatabaseConnector db;
    private final UserDao userDao;
    private final PlaylistDao playlistDao;
    private final SongDao songDao;

    public SearchDao() throws Exception {
        db = new DatabaseConnector();
        userDao = new UserDao();
        songDao = new SongDao();
        playlistDao = new PlaylistDao();
    }

    public List<User> searchUser(String userName) throws Exception {
        List<User> resultUser = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM USER " + 
                "WHERE (fullName LIKE ? OR userId IN "
                + "(SELECT ArtistID FROM songs WHERE Title LIKE ?) "
                + "OR userId IN (SELECT UserID FROM playlists WHERE Title LIKE ?))";
        try  {
            myConn = db.getConnection();
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, "%" + userName + "%");
            myStmt.setString(2, "%" + userName + "%");
            myStmt.setString(3, "%" + userName + "%");
            rs = myStmt.executeQuery();
            while (rs.next()) {
                User us = new User(rs.getString("userId"),rs.getString("fullName"),
                rs.getString("email"),null,null,rs.getString("image_path"));
                resultUser.add(us);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return resultUser;
    }

    public List<Song> searchSong(String songTitle, int limit) throws Exception {
        List<Song> resultSong = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Songs " +
                    "WHERE (Title LIKE ? OR ArtistID IN "
                    +"(SELECT userId FROM user WHERE fullName LIKE ?)) LIMIT ?";
        try {
            myConn = db.getConnection();
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, "%" + songTitle + "%");
            myStmt.setString(2, "%" + songTitle + "%");
            myStmt.setInt(3, limit);
            
            rs = myStmt.executeQuery();
                while (rs.next()) {
                    User user = userDao.getUserById(rs.getString("ArtistID"),true);
                    Song song = new Song(rs.getInt("SongID"),rs.getString("Title"),
                    user,rs.getString("FilePath"),rs.getString("ImagePath"));
                    resultSong.add(song);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSong;
    }

    public List<Search> searchPlaylist(String plTitle) throws Exception {
        List<Search> resultPlaylists = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        String sql = "SELECT Title, UserID, image_path FROM playlists " +
                    "WHERE (Title LIKE ? OR UserID IN "
                + "(SELECT UserID FROM user WHERE fullName LIKE ?))";
        try {
            myConn = db.getConnection();
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, "%" + plTitle + "%");
            myStmt.setString(2, "%" + plTitle + "%");
            rs = myStmt.executeQuery();
            while (rs.next()) {
                User user = userDao.getUserById(rs.getString("UserID"),true);
                Search playlistInfo = new Search(rs.getString("Title"), user, rs.getString("image_path"));
                resultPlaylists.add(playlistInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return resultPlaylists;
    }

}