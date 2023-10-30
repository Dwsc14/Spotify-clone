package com.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnector implements DataInfo {
    public DatabaseConnector() {
    }

    public Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new Exception("Failed to establish a database connection.", e);
        }
        return conn;
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }
}
