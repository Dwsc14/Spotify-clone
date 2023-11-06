package com.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Models.User;

public class UserDao {
    private final DatabaseConnector db;

    public UserDao() throws Exception {
        db = new DatabaseConnector();
    }

    public void updatePremium(String userId, String purDate, String purEnd){
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet rs = null;
        
        try {
            myConn = db.getConnection();
            String sql = "UPDATE user "+
                         "set purchase_date = ?, purchase_end = ?, premium = ? "+
                         "where userId = ?";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, purDate);
            myStmt.setString(2, purEnd);
            myStmt.setString(3, userId);
            myStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(myConn, myStmt, rs);
        }
    }

    public int insertUser(User user) throws SQLException {
        try (Connection myConn = db.getConnection();
             PreparedStatement myStmt = myConn.prepareStatement(
                 "INSERT INTO user (userId, fullName, email, password, salt) VALUES (?, ?, ?, ?, ?)")) {

            myStmt.setString(1, user.getUserId());
            myStmt.setString(2, user.getFullName());
            myStmt.setString(3, user.getEmail());
            myStmt.setString(4, user.getPassword());
            myStmt.setString(5, user.getSalt());

            return myStmt.executeUpdate();
        }catch (Exception e){
            
        }
         return 0;
    }

    public User getUserById(String id, boolean hide) throws SQLException {
        try (Connection myConn = db.getConnection();
             PreparedStatement myStmt = myConn.prepareStatement("SELECT * FROM user WHERE userId = ?")) {

            myStmt.setString(1, id);

            try (ResultSet rs = myStmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs, hide);
                }
            }
        } catch (Exception e){

        }

        return null; // User not found
    }

    public User getUserByMail(String email) throws SQLException {
        try (Connection myConn = db.getConnection();
             PreparedStatement myStmt = myConn.prepareStatement("SELECT * FROM user WHERE email = ?")) {

            myStmt.setString(1, email);

            try (ResultSet rs = myStmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs, false);
                }
            }
        }catch (Exception e){
            
        }

        return null; // User not found
    }

    private User extractUserFromResultSet(ResultSet rs, boolean hide) throws SQLException {
        String nId = rs.getString("userId");
        String fname = rs.getString("fullName");
        String nmail = rs.getString("email");

        String img = rs.getString("image_path");
        if (img == null) {
            img = "static\\img\\def_ava.jpg";
        }

        if (hide){
            String npass = null;
            String nsalt = null;
            return new User(nId, fname, nmail, npass, nsalt, img);
        } else{
            String npass = rs.getString("password");
            String nsalt = rs.getString("salt");
            return new User(nId, fname, nmail, npass, nsalt, img);
        }
    }
}
