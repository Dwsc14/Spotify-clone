package com.Controllers;

import com.Utilities.SearchDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchController extends HttpServlet {

    HttpSession session = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String searchTerm = request.getParameter("search");
//        PrintWriter out = response.getWriter();
//        out.print(searchTerm);

        try {
            String txtSearch = request.getParameter("txtSearch");
//            SearchDAO searchDao = new SearchDAO();
//            List<String> userName = searchDao.searchUser(txtSearch);
//            for (String name : userName) {
//                System.out.println(name);
//            } 
            SearchDAO searchDao = new SearchDAO();
            int count = searchDao.count(txtSearch);
            System.out.println(count);
            request.getRequestDispatcher("testSearch/index.jsp").forward(request, response);
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
