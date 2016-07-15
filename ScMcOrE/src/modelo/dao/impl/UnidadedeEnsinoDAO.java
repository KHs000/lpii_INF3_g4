/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.impl;

import db.ConnectionManager;
import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.IUnidadedeEnsinoDAO;
import modelo.domain.UnidadedeEnsino;

/**
 *
 * @author alunoccc
 */
public class UnidadedeEnsinoDAO implements IUnidadedeEnsinoDAO{

    @Override
    public boolean insere(UnidadedeEnsino u) throws PersistenciaException{
        try {
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("INSERT INTO \"Unidade de Ensino\" (\"nom_Unidade_Ensino\") VALUES" + "('" + u.getNomUnidadeEnsino() + "')"
                    + "RETURNING \"id_Unidade\" ");
            if(rs.next())
                return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadedeEnsinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new PersistenciaException("Falha ao inserir | Erro interno do BD");
    }

    @Override
    public UnidadedeEnsino consultaPorId(Integer id) throws PersistenciaException{
        
        
        try {
            UnidadedeEnsino retorno = new UnidadedeEnsino();
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet resultadoConsulta = s.executeQuery("SELECT * FROM \"Unidade de Ensino\" WHERE \"id_Unidade\"  =  " 
                    + "('" + id + "')");
            if(resultadoConsulta.next()){
                retorno.setNomUnidadeEnsino(resultadoConsulta.getString("nom_Unidade_Ensino"));
                retorno.setIdUnidade(resultadoConsulta.getInt("id_Unidade"));
                return retorno;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadedeEnsinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        throw new PersistenciaException("Falha ao consultar | Erro interno do BD");
    }

    @Override
    public boolean delete(Integer id) throws PersistenciaException {
         try {
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("DELETE FROM \"Unidade de Ensino\" WHERE \"id_Unidade\" = " + id + "RETURNING \"id_Unidade\"");
            if(rs.next())
                return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadedeEnsinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new PersistenciaException("Falha ao deletar | Erro interno do BD");
    }

    @Override
    public boolean atualiza(UnidadedeEnsino u) throws PersistenciaException{
        try {
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("UPDATE \"Unidade de Ensino\" SET \"nom_Unidade_Ensino\" = " + "'" + u.getNomUnidadeEnsino() + "'"
                    + "WHERE \"id_Unidade\" = " + u.getIdUnidade()
                    + "RETURNING  \"id_Unidade\" " 
            );
            if(rs.next())
                return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadedeEnsinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new PersistenciaException("Falha ao atualizar | Erro interno do BD");
    }

    @Override
    public List<UnidadedeEnsino> listaTodas()throws PersistenciaException {
        try {
            List<UnidadedeEnsino> retorno = new ArrayList<UnidadedeEnsino>();
            Connection conexao = ConnectionManager.getInstance().getConnection();
            Statement s = conexao.createStatement();
            ResultSet resultadoConsulta = s.executeQuery("SELECT * FROM \"Unidade de Ensino\" ");
            while(resultadoConsulta.next()){
                UnidadedeEnsino paraSerInserido = new UnidadedeEnsino();
                paraSerInserido.setNomUnidadeEnsino(resultadoConsulta.getString("nom_Unidade_Ensino"));
                paraSerInserido.setIdUnidade(resultadoConsulta.getInt("id_Unidade"));
                retorno.add(paraSerInserido);
            }
            return retorno;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadedeEnsinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        throw new PersistenciaException("Falha ao listar todos | Erro interno do BD");

    }
    
}
