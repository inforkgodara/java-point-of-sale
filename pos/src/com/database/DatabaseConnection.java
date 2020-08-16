/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramesh Godara
 */
public class DatabaseConnection {
    private Connection con;
    private static DatabaseConnection dbc;
    private DatabaseConnection() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","","");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DatabaseConnection getDatabaseConnection() {
        if (dbc == null) {
            dbc = new DatabaseConnection();
        }
        return dbc;
    }
    
    public Connection getConnection() {
        return con;
    }
    
    public static void main(String[] args) {
        new DatabaseConnection();
    }
}
