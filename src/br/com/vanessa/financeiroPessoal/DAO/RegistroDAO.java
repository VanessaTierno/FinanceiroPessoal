/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vanessa.financeiroPessoal.DAO;

import br.com.vanessa.financeiroPessoal.JDBC.ConnectionFactory;
import br.com.vanessa.financeiroPessoal.model.Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class RegistroDAO {
     public static void create(Registro r ){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO registro(descricao,valor,parcela,desconto,valorParcela,tipo,dataVencimento,dataPagamento)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1,r.getDescricao());
            stmt.setDouble(2,r.getValor());
            stmt.setInt(3,r.getParcela());
            stmt.setDouble(4,r.getDesconto());
            stmt.setDouble(5,r.getValorParcela());
            stmt.setString(6,r.getTipo());
            stmt.setTimestamp(7,new Timestamp(r.getDataVencimento().getTimeInMillis()));
            stmt.setTimestamp(8,new Timestamp(r.getDataPagamento().getTimeInMillis()));
            
            stmt.executeUpdate();
            
        
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o registro!" +ex);
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    public static List<Registro> pesquisarMensal(String periodo, String tipo) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        List<Registro> lst = new ArrayList<>();
        try{
            String sql = "select descricao,valor,parcela,desconto,valorParcela,tipo,dataVencimento,dataPagamento from registro where DATE_FORMAT(dataVencimento,'%m/%y') = '"+periodo + "' and tipo in ("+tipo+") order by dataVencimento ;";
            stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Registro r = new Registro();
                r.setDescricao(rs.getString("descricao"));
                r.setValor(rs.getDouble("valor"));
                r.setParcela(rs.getInt("parcela"));
                r.setDesconto(rs.getDouble("desconto"));
                r.setValorParcela(rs.getDouble("valorParcela"));
                r.setTipo(rs.getString("tipo"));
                Calendar dtvenc = Calendar.getInstance();
                dtvenc.setTime(rs.getObject("dataVencimento", Timestamp.class));
                r.setDataVencimento(dtvenc);
                Calendar dtpgto = Calendar.getInstance();
                dtpgto.setTime(rs.getObject("dataPagamento", Timestamp.class));
                r.setDataPagamento(dtpgto);
                lst.add(r);                
            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o registro!" +ex);
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lst;
        
    }
  
    public static List<Registro> pesquisarAnual(String periodo, String tipo) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        List<Registro> lst = new ArrayList<>();
        try{
            String sql = "select descricao,valor,parcela,desconto,valorParcela,tipo,dataVencimento,dataPagamento from registro where DATE_FORMAT(dataVencimento,'%y') = '"+periodo+"' and tipo in("+tipo+") order by dataVencimento;";
            stmt = con.prepareStatement(sql );
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Registro r = new Registro();
                r.setDescricao(rs.getString("descricao"));
                r.setValor(rs.getDouble("valor"));
                r.setParcela(rs.getInt("parcela"));
                r.setDesconto(rs.getDouble("desconto"));
                r.setValorParcela(rs.getDouble("valorParcela"));
                r.setTipo(rs.getString("tipo"));
                Calendar dtvenc = Calendar.getInstance();
                dtvenc.setTime(rs.getObject("dataVencimento", Timestamp.class));
                r.setDataVencimento(dtvenc);
                Calendar dtpgto = Calendar.getInstance();
                dtpgto.setTime(rs.getObject("dataPagamento", Timestamp.class));
                r.setDataPagamento(dtpgto);
                lst.add(r);                
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o registro!" +ex);
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lst;
    }
    
    public static Double somarMes(String periodo, String tipo) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            String sql = "select sum(valor-desconto)AS TOTAL from registro where DATE_FORMAT(dataVencimento,'%m/%y') = '"+periodo+"' and tipo in("+tipo+")";
            stmt = con.prepareStatement(sql );
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                return rs.getDouble("TOTAL");
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao somar!" +ex);
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return 0d;
    }
    
    public static Double somarAno(String periodo, String tipo) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            String sql = "select sum(valor-desconto)AS TOTAL from registro where DATE_FORMAT(dataVencimento,'%y') = '"+periodo+"' and tipo in("+tipo+")";
            stmt = con.prepareStatement(sql );
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                return rs.getDouble("TOTAL");
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao somar!" +ex);
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return 0d;
    }
}
