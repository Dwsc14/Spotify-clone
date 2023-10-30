package com.Utilities;

import com.Models.Playlist;
import com.Models.Song;
import com.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Map<Integer, Playlist> getPlistById(String userID) throws Exception {
        Map<Integer, Playlist> playlistMap = new HashMap<>();

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;

        try {
            myConn = db.getConnection();
            String sql = "SELECT Playlists.PlaylistID, Playlists.Title AS PlaylistTitle, " +
                    "Songs.SongID, Songs.Title, Songs.ArtistID, Songs.FilePath, Songs.ImagePath " +
                    "FROM Songs " +
                    "INNER JOIN PlaylistSongs ON Songs.SongID = PlaylistSongs.SongID " +
                    "INNER JOIN Playlists ON PlaylistSongs.PlaylistID = Playlists.PlaylistID " +
                    "INNER JOIN user ON Songs.ArtistID = user.userId " +
                    "WHERE Playlists.UserID = ? " +
                    "ORDER BY Playlists.PlaylistID";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, userID);
            rs = myStmt.executeQuery();

            while (rs.next()) {
                int playlistID = rs.getInt("PlaylistID");
                if (!playlistMap.containsKey(playlistID)) {
                    Playlist playlist = new Playlist(playlistID, rs.getString("PlaylistTitle"), new ArrayList<>());
                    playlistMap.put(playlistID, playlist);
                }

                User user = userDao.getUserById(rs.getString("ArtistID"));

                Song song = new Song(rs.getInt("SongID"), rs.getString("Title"), user, rs.getString("FilePath"), rs.getString("ImagePath"));
                playlistMap.get(playlistID).getSongs().add(song);
            }

            return playlistMap;
        } finally {
            db.close(myConn, myStmt, rs);
        }
    }
}
