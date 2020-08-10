/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vanessa.financeiroPessoal.JDBC.teste;

import br.com.vanessa.financeiroPessoal.JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author alan
 */
public class TestaConexao {
    
    public static void main(String[] args) throws SQLException {
        
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();        
    }
}
