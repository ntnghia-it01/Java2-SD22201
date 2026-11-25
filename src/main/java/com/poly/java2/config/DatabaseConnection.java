/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.java2.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author trongnghia
 */
public class DatabaseConnection {
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "123456@Aa";
    private static final String DB_DATABASE_NAME = "java2";
    
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String url = "jdbc:sqlserver://localhost:1433;database=" 
                    + DB_DATABASE_NAME 
                    + ";encrypt=true;trustServerCertificate=true";
            
            Connection con = DriverManager.getConnection(url,
                    DB_USERNAME,
                    DB_PASSWORD);
            
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
