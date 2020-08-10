/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vanessa.financeiroPessoal.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alan
 */
public class ConnectionFactory {
   public static Connection getConnection(){
    try {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/financeiroPessoal", "root", "nessa0512");
    }catch (SQLException e){
        throw new RuntimeException(e);
    }
   }
   
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        try{
            if (con != null){
                stmt.close();
                con.close();
            }
        } catch (SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
