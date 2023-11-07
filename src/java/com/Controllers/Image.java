
package com.Controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.Models.User;
import com.Utilities.PlaylistDao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.annotation.MultipartConfig;

@WebServlet(name = "Image", urlPatterns = {"/Image"})
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 4,      
        maxRequestSize = 1024 * 1024 * 4 ,  
        fileSizeThreshold = 1024 * 1024 * 4
)
public class Image extends HttpServlet {
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

        if (user == null){
            response.sendRedirect("login");
        }

        String uploadPath = getServletContext().getRealPath("/storage/" + user.getUserId() + "/image/");

        try {
            Part imagePart = request.getPart("image");       

            System.out.println(imagePart);

            int id = pldao.getMaxId() + 1;
            String nameOfPlist = request.getParameter("plist-name");
            
            String temp = getFileName(imagePart);
            String fileExtension = temp.substring(temp.lastIndexOf(".") + 1);
            String fileName = "pl+" + Integer.toString(id) + "." + fileExtension;

            String fullPath = "storage\\" + user.getUserId() + "\\image\\" + fileName;

            OutputStream out = null;
            InputStream filecontent = null;
        

            try {
                out = new FileOutputStream(new File(uploadPath + File.separator
                        + fileName));
                filecontent = imagePart.getInputStream();
                
                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                
                pldao.createPlaylist(id, user.getUserId(), nameOfPlist, fullPath);

            } catch (FileNotFoundException fne) {
            }
            response.sendRedirect("playlist?playlistId="+Integer.toString(id));
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
