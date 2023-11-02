package com.Utilities;

import com.Models.Song;
import com.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SongDao {
    private final DatabaseConnector db;
    private final UserDao userDao;

    public SongDao() throws Exception {
        db = new DatabaseConnector();
        userDao = new UserDao();
    }

    public Song getSongById(int id){
        Song song = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;

        try {
            myConn = db.getConnection();
            String sql = "select * from Songs where SongID = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, id);

            rs = myStmt.executeQuery();

            while (rs.next()) {
                User user = userDao.getUserById(rs.getString("ArtistID"));
                song = new Song(rs.getInt("SongID"), rs.getString("title"),user ,rs.getString("FilePath"), rs.getString("ImagePath"));
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return song;
    }

    public List<Song> getSongbyNum(int limit) {
        List<Song> songs = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;

        try {
            myConn = db.getConnection();
            String sql = "SELECT * FROM Songs ORDER BY ReleaseDate LIMIT ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, limit);

            rs = myStmt.executeQuery();

            while (rs.next()) {
                User user = userDao.getUserById(rs.getString("ArtistID"));
                Song song = new Song(rs.getInt("SongID"), rs.getString("Title"), user, rs.getString("FilePath"), rs.getString("ImagePath"));
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return songs;
    }
}
