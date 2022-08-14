/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.qlpm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author datly
 */
public class JdbcUtils {
    private Connection conn;
    static {
        try {
            Class.forName("jdbc.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the conn
     */
    public Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/qlpm", "root", "123456");
    }
}
