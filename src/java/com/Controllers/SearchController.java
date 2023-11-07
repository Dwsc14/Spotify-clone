package com.Controllers;

import com.Models.Playlist;
import com.Models.Search;
import com.Models.Song;
import com.Models.User;
import com.Utilities.PlaylistDao;
import com.Utilities.SearchDAO;
import com.Utilities.SongDao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchController extends HttpServlet {

    HttpSession session = null;
    PlaylistDao pldao;

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
        try {
            User user = (User) session.getAttribute("User");

            String txtSearch = request.getParameter("txtSearch");
            SearchDAO searchDao = new SearchDAO();
            List<User> userName = searchDao.searchUser(txtSearch);
            List<Song> songName = searchDao.searchSong(txtSearch,4);
            List<Search> playListName = searchDao.searchPlaylist(txtSearch);

            List<Playlist> plist = pldao.getPlist(user.getUserId());
            Map<Integer, String> listPL =  pldao.getNameIdListById(user.getUserId());
            request.setAttribute("playlist", plist);
            request.setAttribute("playlists", listPL);


            request.setAttribute("searchUser", userName);
            request.setAttribute("searchSong", songName);
            request.setAttribute("searchPlaylist", playListName);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("searchPage/index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            try {
                processRequest(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("login");
        };
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
