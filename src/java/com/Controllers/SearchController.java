package com.Controllers;

import com.Models.Playlist;
import com.Models.Search;
import com.Models.Song;
import com.Models.User;

import com.Utilities.SearchDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchController extends HttpServlet {

    HttpSession session = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String txtSearch = request.getParameter("txtSearch");
            SearchDao searchDao = new SearchDao();
            List<User> userName = searchDao.searchUser(txtSearch);
            List<Song> songName = searchDao.searchSong(txtSearch,4);
            List<Search> playListName = searchDao.searchPlaylist(txtSearch);

            request.setAttribute("searchUser", userName);
            request.setAttribute("searchSong", songName);
            request.setAttribute("searchPlaylist", playListName);
            
            System.out.println(userName);

            RequestDispatcher dispatcher = request.getRequestDispatcher("searchPage/index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
