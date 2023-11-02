package com.Utilities;

import com.Models.Playlist;
import com.Models.Song;
import com.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlaylistDao {
    private final DatabaseConnector db;
    private final UserDao userDao;

    public PlaylistDao() throws Exception {
        db = new DatabaseConnector();
        userDao = new UserDao();
    }

    public void delSongToPlaylist(int playlistID, int songID) throws Exception {
        String sql = "DELETE FROM Playlistsongs WHERE PlaylistID = ? AND SongID = ?";
        try (Connection myConn = db.getConnection();
            PreparedStatement myStmt = myConn.prepareStatement(sql)) {
            myStmt.setInt(1, playlistID);
            myStmt.setInt(2, songID);
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSongToPlaylist(int playlistID, int songID) throws Exception {
        String sql = "INSERT INTO Playlistsongs(PlaylistID, SongID) VALUES (?, ?)";
        try (Connection myConn = db.getConnection();
             PreparedStatement myStmt = myConn.prepareStatement(sql)) {
            myStmt.setInt(1, playlistID);
            myStmt.setInt(2, songID);
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, String> getNameIdListById(String userID) throws Exception {
        Map<Integer, String> playlistMap = new HashMap<>();
        String sql = "SELECT PlaylistID, Title FROM Playlists WHERE UserID = ?";
        try (Connection myConn = db.getConnection();
             PreparedStatement myStmt = myConn.prepareStatement(sql)) {
            myStmt.setString(1, userID);
            try (ResultSet rs = myStmt.executeQuery()) {
                while (rs.next()) {
                    playlistMap.put(rs.getInt("PlaylistID"), rs.getString("Title"));
                }
            }
        } catch (SQLException e) {
            // Xử lý lỗi SQL
            e.printStackTrace();
        }
        return playlistMap;
    }

    public Map<Integer, Playlist> getPlistById(String userID) throws Exception {
        Map<Integer, Playlist> playlistMap = new HashMap<>();
        String sql = "SELECT Playlists.PlaylistID, Playlists.Title AS PlaylistTitle, " +
                     "Songs.SongID, Songs.Title, Songs.ArtistID, Songs.FilePath, Songs.ImagePath " +
                     "FROM Songs " +
                     "INNER JOIN PlaylistSongs ON Songs.SongID = PlaylistSongs.SongID " +
                     "INNER JOIN Playlists ON PlaylistSongs.PlaylistID = Playlists.PlaylistID " +
                     "INNER JOIN User ON Songs.ArtistID = User.UserId " +
                     "WHERE Playlists.UserID = ? " +
                     "ORDER BY Playlists.PlaylistID";
        try (Connection myConn = db.getConnection();
             PreparedStatement myStmt = myConn.prepareStatement(sql)) {
            myStmt.setString(1, userID);
            try (ResultSet rs = myStmt.executeQuery()) {
                while (rs.next()) {
                    int playlistID = rs.getInt("PlaylistID");
                    playlistMap.computeIfAbsent(playlistID, key -> {
                        try {
                            return new Playlist(playlistID, rs.getString("PlaylistTitle"), new ArrayList<>());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return null;
                    });
                    User user = userDao.getUserById(rs.getString("ArtistID"));
                    Song song = new Song(rs.getInt("SongID"), rs.getString("Title"), user, rs.getString("FilePath"), rs.getString("ImagePath"));
                    playlistMap.get(playlistID).addSong(song);
                }
            }
        } catch (SQLException e) {
            // Xử lý lỗi SQL
            e.printStackTrace();
        }
        return playlistMap;
    }
}