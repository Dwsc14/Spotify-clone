package com.Controllers;

import com.Models.Playlist;
import com.Models.Search;
import com.Models.Song;
import com.Models.User;
import com.Utilities.PlaylistDao;
import com.Utilities.ProfileDao;
import com.Utilities.SongDao;
import com.Utilities.UserDao;

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
    UserDao userDao;
    PlaylistDao pldao;
    HttpSession session = null;

    public void init() throws ServletException {
        super.init();
        try {
            dao = new SongDao();
            pldao = new PlaylistDao();
            userDao = new UserDao();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        String userID = request.getParameter("userID");
        try {
            User user = (User) session.getAttribute("User");
            List<Playlist> plist = pldao.getPlist(user.getUserId());
            Map<Integer, String> listPL =  pldao.getNameIdListById(user.getUserId());
            request.setAttribute("playlist", plist);
            request.setAttribute("playlists", listPL);

            User usr = userDao.getUserById(userID, true);

            ProfileDao profileDao = new ProfileDao();
            List<Song> songOfUser = profileDao.getSongofUser(userID);
            List<Search>playlistOfUser = profileDao.getPlayListofUser(userID);
            
            request.setAttribute("usr", usr);
            request.setAttribute("songOfUser", songOfUser);
            request.setAttribute("playlistOfUser", playlistOfUser);
            
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
