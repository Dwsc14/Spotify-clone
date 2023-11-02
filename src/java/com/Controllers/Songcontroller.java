package com.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Models.Playlist;
import com.Models.Song;
import com.Utilities.PlaylistDao;
import com.Utilities.SongDao;

@WebServlet(name = "Songcontroller", urlPatterns = {"/Songcontroller"})
public class Songcontroller extends HttpServlet {

    private SongDao dao;
    private PlaylistDao pldao;
    HttpSession session = null;
    
    public void init() throws ServletException {
        super.init();
        try {
            dao = new SongDao();
            pldao = new PlaylistDao();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String status = null;
        String id_str = request.getParameter("songId");
        String playlist = request.getParameter("playlist");
        String action = request.getParameter("action");

        if (action == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id = Integer.parseInt(id_str);
        int pl_id = Integer.parseInt(playlist);

        try {
            if ("add".equals(action)) {
                if (!checkSongInPlist(id, pl_id, request)) {
                    status = "duplicated";
                } else {
                    pldao.addSongToPlaylist(pl_id, id);
                    status = "success";
                }
            } else if ("delete".equals(action)) {
                if (checkSongInPlist(id, pl_id, request)) {
                    pldao.delSongToPlaylist(pl_id, id);
                    status = "success";
                }
            }
        } catch (Exception e) {
            log("Xảy ra lỗi khi xử lý yêu cầu: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        response.setContentType("text/plain");
        response.getWriter().write(status);

    }

    protected boolean checkSongInPlist(int songID, int playlistID, HttpServletRequest request){
        session = request.getSession();
        Map<Integer, Playlist> plist = (Map<Integer, Playlist>) session.getAttribute("playlist"); 

        Playlist pl = plist.get(playlistID);
        List<Song> songs = pl.getSongs();
        System.out.println(plist);
        for (int i = 0; i < pl.getSize() ; i++) {
            System.out.println(songs.get(i).getId() + " / " + songID);
            if (songs.get(i).getId() == songID){
                System.out.println("Find matching!");
                return false;
            }
        }

        Song song = dao.getSongById(songID);
        plist.get(playlistID).addSong(song);
        session.setAttribute("playlist", plist);
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
