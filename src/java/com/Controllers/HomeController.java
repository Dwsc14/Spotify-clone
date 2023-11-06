package com.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.Utilities.SongDao;

public class HomeController extends HttpServlet {

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
            User user = (User) session.getAttribute("User");

            List<Playlist> plist = pldao.getPlist(user.getUserId());
            System.out.println(plist);
            request.setAttribute("playlist", plist);

            List<Song> recommend_songs = (List<Song>) dao.getSongbyNum(5);
            List<Song> random_songs = (List<Song>) dao.getRandomSongbyNum(5);


            request.setAttribute("Recommend", recommend_songs);
            request.setAttribute("Random", random_songs);

            RequestDispatcher dispatcher = request.getRequestDispatcher("mainPage/index.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.print(e);
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
