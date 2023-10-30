package com.Controllers;

import com.Models.Playlist;
import com.Models.Song;
import com.Utilities.PlaylistDao;

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
    private PlaylistDao dao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("playlist") != null) {
            int id = Integer.parseInt(request.getParameter("playlist"));
            Object sessionData = session.getAttribute("playlist");
            if (sessionData instanceof Map<?, ?>) {
                Map<Integer, Playlist> playlist = (Map<Integer, Playlist>) sessionData;
                List<Song> songs = playlist.get(id).getSongs();
                request.setAttribute("songs", songs);
                RequestDispatcher dispatcher = request.getRequestDispatcher("demo_test/index_playlist.jsp");
                dispatcher.forward(request, response);
            }
        }

        try {
            if (dao == null) {
                dao = new PlaylistDao();
            }
            
            // User user = (User) session.getAttribute("User"); 
            // String id =  user.getUserId();

            String userId = "1698320801014-dd034f24-22f9-41ff-9c7a-04d696482b18";
            Map<Integer, Playlist> playlist = dao.getPlistById(userId);
            session.setAttribute("playlist", playlist);
            RequestDispatcher dispatcher = request.getRequestDispatcher("demo_test/index_playlist.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred.");
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
