package com.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;
import java.time.Instant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Models.Song;
import com.Models.User;
import com.Utilities.SongDao;
import com.Utilities.UserDao;

public class LoginController extends HttpServlet {
    private UserDao userDao;
    private SongDao dao;

    public void init() throws ServletException {
        super.init();
        try {
            userDao = new UserDao();
            dao = new SongDao();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (!request.getParameter("pswd").isEmpty() && !request.getParameter("repswd").isEmpty()) {
            // Register
            String fname = request.getParameter("full_name");
            String email = request.getParameter("email");
            String pswd = request.getParameter("pswd");
            String re_pswd = request.getParameter("repswd");

            if (pswd.equals(re_pswd)) {
                User user = new User();
                user.setFullName(fname);
                user.setEmail(email);

                String userID = Instant.now().toEpochMilli() + "-" + UUID.randomUUID().toString();
                String salt = generateSalt();
                pswd = hashPassword(pswd, salt);

                user.setSalt(salt);
                user.setPassword(pswd);
                user.setUserId(userID);

                try {
                    userDao.insertUser(user);
                } catch (Exception ex) {
                    
                }

            } else {
                // Handle password mismatch
            }

        } else {
            String email = request.getParameter("email");
            String pswd = request.getParameter("pswd");

            try {
                User user = userDao.getUserByMail(email);

                if (user != null && verifyPassword(pswd, user.getSalt(), user.getPassword())) {
                    session.setAttribute("User", user);
                    
                    response.sendRedirect("HomeController");

                } else {
                    System.out.println("Saiiii");
                }
            } catch (Exception ex) {
                PrintWriter out = response.getWriter();
                out.print(ex);
            }
        }
    }

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return new String(salt);
    }

    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            String saltedPassword = salt + password;

            byte[] saltedPasswordBytes = saltedPassword.getBytes();

            byte[] hash = md.digest(saltedPasswordBytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verifyPassword(String enteredPassword, String salt, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            String saltedEnteredPassword = salt + enteredPassword;

            byte[] saltedEnteredPasswordBytes = saltedEnteredPassword.getBytes();

            byte[] hash = md.digest(saltedEnteredPasswordBytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            String enteredPasswordHash = hexString.toString();

            return enteredPasswordHash.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        if (user != null) {
            try {
                List<Song> songs = dao.getSongbyNum(5);
                request.setAttribute("Recommend", songs);

                RequestDispatcher dispatcher = request.getRequestDispatcher("demo_test/index.jsp");
                dispatcher.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
                // Handle the exception properly
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginPage/login.html");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
