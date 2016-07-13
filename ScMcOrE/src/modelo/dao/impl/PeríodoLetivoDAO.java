/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.impl;

import db.ConnectionManager;
import db.PersistenciaException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.IPeriodoLetivoDAO;
import modelo.domain.PeríodoLetivo;
import modelo.domain.PeríodoLetivo;

/**
 *
 * @author Conta Única
 */
public class PeríodoLetivoDAO implements IPeriodoLetivoDAO{
    SimpleDateFormat formatoPSQL = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public boolean insere(PeríodoLetivo u) throws PersistenciaException{
        try {
            
            String dat_inicio = formatoPSQL.format(u.getDatInicio());
            String dat_fim = formatoPSQL.format(u.getDatFim());
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("INSERT INTO \"Período Letivo\" (\"idt_Regime\",\"dat_Inicio\",\"dat_Fim\") " + 
                    "VALUES ('" + u.getIdtRegime() +  "'," + "'" + dat_inicio +"'," + "'" + dat_fim + "')"
                    + "RETURNING \"idt_Periodo\" ");
            if(rs.next())
                return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PeríodoLetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new PersistenciaException("Falha ao inserir | Erro interno do BD");
    }

    @Override
    public PeríodoLetivo consultaPorId(Integer id) throws PersistenciaException{
        
        
        try {
            PeríodoLetivo retorno = new PeríodoLetivo();
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet resultadoConsulta = s.executeQuery("SELECT * FROM \"Período Letivo\" WHERE \"idt_Periodo\"  =  " 
                    + "('" + id + "')");
            if(resultadoConsulta.next()){
                retorno.setIdtPeriodo(resultadoConsulta.getInt("idt_Periodo"));
                retorno.setIdtRegime(resultadoConsulta.getString("idt_Regime").charAt(0));
                retorno.setDatInicio(resultadoConsulta.getDate("dat_Inicio"));
                retorno.setDatFim(resultadoConsulta.getDate("dat_Fim"));
                return retorno;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PeríodoLetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        throw new PersistenciaException("Falha ao consultar | Erro interno do BD");
    }

    @Override
    public boolean delete(Integer id) throws PersistenciaException {
         try {
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("DELETE FROM \"Período Letivo\" WHERE \"idt_Periodo\" = " + id + "RETURNING \"idt_Periodo\"");
            if(rs.next())
                return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PeríodoLetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new PersistenciaException("Falha ao deletar | Erro interno do BD");
    }

    @Override
    public boolean atualiza(PeríodoLetivo u) throws PersistenciaException{
        try {
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("UPDATE \"Período Letivo\" "
                    + "SET \"idt_Regime\" = " + "'" + u.getIdtRegime() + "'"
                    + ", \"dat_Inicio\" = " + "'" + formatoPSQL.format(u.getDatInicio()) + "'"
                     + ", \"dat_Fim\" = " + "'" + formatoPSQL.format(u.getDatFim()) + "'"
                    + "WHERE \"idt_Periodo\" = " + u.getIdtPeriodo()
                    + "RETURNING  \"idt_Periodo\" " 
            );
            if(rs.next())
                return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PeríodoLetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new PersistenciaException("Falha ao atualizar | Erro interno do BD");
    }

    @Override
    public List<PeríodoLetivo> listaTodas()throws PersistenciaException {
        try {
            List<PeríodoLetivo> retorno = new ArrayList<PeríodoLetivo>();
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet resultadoConsulta = s.executeQuery("SELECT * FROM \"Período Letivo\" ");
            while(resultadoConsulta.next()){
                PeríodoLetivo paraSerInserido = new PeríodoLetivo();
                paraSerInserido.setIdtPeriodo(resultadoConsulta.getInt("idt_Periodo"));
                paraSerInserido.setIdtRegime(resultadoConsulta.getString("idt_Regime").charAt(0));
                paraSerInserido.setDatInicio(resultadoConsulta.getDate("dat_Inicio"));
                paraSerInserido.setDatFim(resultadoConsulta.getDate("dat_Fim"));
                retorno.add(paraSerInserido);
            }
            return retorno;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PeríodoLetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        throw new PersistenciaException("Falha ao listar todos | Erro interno do BD");

    }
    
}
