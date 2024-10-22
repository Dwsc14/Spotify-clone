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
import java.util.List;
import java.util.Map;

public class PlaylistDao {
    private final DatabaseConnector db;
    private final UserDao userDao;

    public PlaylistDao() throws Exception {
        db = new DatabaseConnector();
        userDao = new UserDao();
    }


    public int getMaxId(){
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;

        try {
            myConn = db.getConnection();
            String sql = "SELECT MAX(playlistId) as max  FROM playlists";

            myStmt = myConn.prepareStatement(sql);
            rs = myStmt.executeQuery();

            while (rs.next()) {
                return rs.getInt("max");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return 0;
    }

    public Playlist getPlistByPlistID(int playlistID){
        Playlist pl = null;
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;

        try {
            myConn = db.getConnection();
            String sql = "SELECT playlists.title as PL_title, playlists.image_path as PL_img, playlists.UserID as PL_userID, " +
                         "songs.SongID as S_id, songs.Title as S_title, songs.ArtistID as S_userID, songs.FilePath as S_src, songs.ImagePath as S_img " +
                         "FROM playlists "+
                         "JOIN playlistsongs ON playlists.PlaylistID = playlistsongs.PlaylistID "+
                         "JOIN songs ON playlistsongs.SongID = songs.SongID "+
                         "WHERE playlists.PlaylistID = ?";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, playlistID);

            rs = myStmt.executeQuery();

            while (rs.next()) {
                if (pl == null){
                    pl = new Playlist(playlistID, rs.getString("PL_title"), new ArrayList<>(), rs.getString("PL_img"));
                }
                User user = userDao.getUserById(rs.getString("S_userID"), true);
                Song song = new Song(rs.getInt("S_id"), rs.getString("S_title"), user, rs.getString("S_src"), rs.getString("S_img"));
                pl.addSong(song);
            }
            return pl;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return pl;
    }

    public List<Song> getSongofPLaylist(int playlistID){
        List<Song> songs = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        try {
            myConn = db.getConnection();
            String sql = "SELECT songs.* FROM songs " +
                         "JOIN playlistsongs ON songs.SongID = playlistsongs.SongID " +
                         "WHERE playlistsongs.PlaylistID = ?";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, playlistID);

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
    

    public void createPlaylist(int playlistID, String userID, String Title, String path){
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        
        try {
            myConn = db.getConnection();
            String sql = "insert into playlists(PlaylistID, Title, UserID, image_path) " + 
                         "values ( ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, playlistID);
            myStmt.setString(2, Title);
            myStmt.setString(3, userID);
            myStmt.setString(4, path);

            myStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
    }

    public void delSongToPlaylist(int playlistID, int songID){
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        
        try {
            myConn = db.getConnection();
            String sql = "DELETE FROM Playlistsongs WHERE PlaylistID = ? AND SongID = ?";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, playlistID);
            myStmt.setInt(2, songID);
            myStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
    }

    public void addSongToPlaylist(int playlistID, int songID){
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        
        try {
            myConn = db.getConnection();
            String sql = "insert into Playlistsongs(PlaylistID, SongID) values (?, ?);";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, playlistID);
            myStmt.setInt(2, songID);
            myStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
    }

    public Playlist getPlistByID(int PlaylistID){
        Playlist playlist = new Playlist();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;

        try {
            myConn = db.getConnection();
            String sql = "SELECT * FROM Playlists WHERE PlaylistID = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, PlaylistID);

            rs = myStmt.executeQuery();

            while (rs.next()) {
                playlist = new Playlist(rs.getInt("PlaylistID"), rs.getString("Title"), new ArrayList<>(), rs.getString("image_path"));
            }
            return playlist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return playlist;
    }

    public List<Playlist> getPlist(String userID){
        List<Playlist> playlists = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;

        try {
            myConn = db.getConnection();
            String sql = "SELECT * FROM Playlists WHERE UserID = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, userID);

            rs = myStmt.executeQuery();

            while (rs.next()) {
                System.out.println("Ahihi");
                Playlist temp = new Playlist(rs.getInt("PlaylistID"), rs.getString("Title"), new ArrayList<>(), rs.getString("image_path"));
                playlists.add(temp);
            }
            return playlists;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return playlists;
    }

    public Map<Integer, String> getNameIdListById(String userID){
        Map<Integer, String> playlistMap = new HashMap<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;

        try {
            myConn = db.getConnection();
            String sql = "SELECT PlaylistID, Title FROM Playlists WHERE UserID = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, userID);

            rs = myStmt.executeQuery();

            while (rs.next()) {
                playlistMap.put(rs.getInt("PlaylistID"), rs.getString("Title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
        return playlistMap;
    }

    public Map<Integer, Playlist> getPlistById(String userID) throws Exception {
        Map<Integer, Playlist> playlistMap = new HashMap<>();
        String sql = "SELECT Playlists.PlaylistID, Playlists.Title AS PlaylistTitle, " +
                    "Songs.SongID, Songs.Title, Songs.ArtistID, Songs.FilePath, Songs.ImagePath, Playlists.image_path as playlist_img " +
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
                            return new Playlist(playlistID, rs.getString("PlaylistTitle"), new ArrayList<>(), rs.getString("playlist_img"));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return null;
                    });
                    User user = userDao.getUserById(rs.getString("ArtistID"), true);
                    Song song = new Song(rs.getInt("SongID"), rs.getString("Title"), user, rs.getString("FilePath"), rs.getString("ImagePath"));
                    playlistMap.get(playlistID).addSong(song);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playlistMap;
    }
}