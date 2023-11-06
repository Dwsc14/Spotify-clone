
package com.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Models.TransactionData;
import com.Models.User;
import com.Utilities.PlaylistDao;
import com.Utilities.SongDao;
import com.Utilities.UserDao;
import com.google.gson.Gson;
import java.time.LocalDate;

@WebServlet(name = "payment", urlPatterns = {"/payment"})
public class Payment extends HttpServlet {
    HttpSession session = null;
    UserDao dao;

    public void init() throws ServletException {
        super.init();
        try {
            dao = new UserDao();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("payPage/index.jsp");
            dispatcher.forward(request, response);  
        } else {
            response.sendRedirect("login");
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
        
        try {
            String requestData = request.getReader().readLine();
            Gson gson = new Gson();
            TransactionData transactionData = gson.fromJson(requestData, TransactionData.class);
            String orderId = transactionData.getOrderId();
            int days = 0;

            String pack = transactionData.getStatus();
            if ("basic-plan".equals(pack)){
                days = 60;
            } else if ("standard-plan".equals(pack)){
                days = 90;
            } else {
                days = 365;
            }
            
            LocalDate currentDate = LocalDate.now();
            LocalDate futureDate = currentDate.plusDays(days);

            dao.updatePremium(currentDate.toString(), futureDate.toString(), orderId);

        } catch (Exception e) {
            processRequest(request, response);
        }
    }
}
