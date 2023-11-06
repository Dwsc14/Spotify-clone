package com.Controllers;

import com.Models.Playlist;
import com.Models.Song;
import com.Utilities.PlaylistDao;
import com.Utilities.ProfileDao;
import com.Utilities.SongDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProfileController", urlPatterns = {"/ProfileController"})
public class ProfileController extends HttpServlet {
    SongDao dao;
    PlaylistDao pldao;
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
        session = request.getSession();
        try {
            ProfileDao profileDao = new ProfileDao();
            List<Song> songOfUser = profileDao.getSongofUser("1698672041682-cb95e995-efa4-4b4f-96b8-de05c43a644f");
            
            session.setAttribute("songOfUser", songOfUser);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("profile/index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
        }
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
