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
        
        session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            String user_id = user.getUserId();
            Map<Integer, String> listPL =  pldao.getNameIdListById(user_id);
            request.setAttribute("playlists", listPL);
        }

        String rq = request.getParameter("playlistId");
        int playlistID = Integer.parseInt(rq);
        
        Playlist pl = pldao.getPlistByPlistID(playlistID);

        List<Song> songs = pl.getSongs();
        
        request.setAttribute("title", pl.getTitle());
        request.setAttribute("img", pl.getImagePath());
        request.setAttribute("size", pl.getSize());
        request.setAttribute("songs", songs);
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
