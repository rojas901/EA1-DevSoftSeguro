/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.gestionpersonal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author caran
 */
public class ConnectionUtil {
    
    private static final String URL = "jdbc:postgresql://db.meecvvgcvpqrvmsqqnjf.supabase.co:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "manizales*2022";
    
    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
