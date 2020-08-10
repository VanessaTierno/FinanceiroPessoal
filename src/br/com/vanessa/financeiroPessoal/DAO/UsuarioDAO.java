/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vanessa.financeiroPessoal.DAO;


import br.com.vanessa.financeiroPessoal.JDBC.ConnectionFactory;
import br.com.vanessa.financeiroPessoal.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class UsuarioDAO {
    
    public static void create(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO usuario(nome,email,senha)VALUES(?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            
            stmt.executeUpdate();
            
        
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: a senha deve conter no máximo 9 caracteres." +ex);
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public static boolean buscarUsuario(Usuario b) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("select * from usuario where nome = ? and senha = ?;");
            stmt.setString(1, b.getNome());
            stmt.setString(2, b.getSenha());
            
            ResultSet rs = stmt.executeQuery();
            rs.next();
            if(!b.getNome().equals(rs.getString("nome")))
                return false;
            if(!b.getSenha().equals(rs.getString("senha")))
                return false;
        
           
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Usuário não encontrado !!!" +ex);
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    return true; 
    }
}
