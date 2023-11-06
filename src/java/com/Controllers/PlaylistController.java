package com.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Models.Playlist;
import com.Models.Song;
import com.Models.User;
import com.Utilities.PlaylistDao;

public class PlaylistController extends HttpServlet {
    private PlaylistDao pldao;
    HttpSession session = null;

    public void init() throws ServletException {
        super.init();
        try {
            pldao = new PlaylistDao();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String rq = request.getParameter("playlistId");
        int playlistID = Integer.parseInt(rq);

        
        if ("add".equals(action)){
            String rqSong = request.getParameter("songId");
            int songID = Integer.parseInt(rqSong);

        } else if ("del".equals(action)){
            String rqSong = request.getParameter("songId");
            int songID = Integer.parseInt(rqSong);

            pldao.delSongToPlaylist(playlistID, songID);
        } 

        session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            List<Playlist> plist = pldao.getPlist(user.getUserId());
            String user_id = user.getUserId();
            Map<Integer, String> listPL =  pldao.getNameIdListById(user_id);
            request.setAttribute("playlist", plist);
            request.setAttribute("playlists", listPL);
        }

        
        Playlist pl = pldao.getPlistByPlistID(playlistID);
        

        if (pl != null){
            List<Song> songs = pl.getSongs();
            request.setAttribute("songs", songs);
        } else {
            pl = pldao.getPlistByID(playlistID);
        }
        request.setAttribute("title", pl.getTitle());
        request.setAttribute("img", pl.getImagePath());
        request.setAttribute("size", pl.getSize());
        request.setAttribute("id", playlistID);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("infoPlayList/index.jsp");
        dispatcher.forward(request, response);
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
