/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.impl;

import db.ConnectionManager;
import db.PostgresqlConnection;
import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.IAlocaçãoDAO;
import modelo.domain.Alocação;

/**
 *
 * @author Cliente
 */
public class AlocaçãoDAO implements IAlocaçãoDAO{

    @Override
    public Integer inserir(Alocação obj) throws PersistenciaException {
        Integer id = null;

        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "INSERT INTO Alocação (id_Alocacao, dat_Alocacao, cpf_Professor, id_Ambiente) " + "VALUES(?, ?, ?, ?) RETURNING id_Alocacao";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, obj.getIdAlocacao());
            statement.setDate(2, obj.getDatAlocacao());
            statement.setString(3, obj.getCpfProfessor().getCpfProfessor());
            statement.setInt(4, obj.getIdAmbiente().getIdAmbiente());
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                obj.setIdAlocacao(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }
    
    @Override
    public void atualizar(Alocação obj) throws PersistenciaException {
        try{
            Connection connection = new PostgresqlConnection().getConnection();
            String sql = "UPDATE Alocação SET dat_Alocacao = ? , cpf_Professor = ? , id_Ambiente = ? WHERE id_Alocacao = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDate(1, obj.getDatAlocacao());
            statement.setString(2, obj.getCpfProfessor().getCpfProfessor());
            statement.setInt(3, obj.getIdAmbiente().getIdAmbiente());
            statement.setInt(4, obj.getIdAlocacao());
            
            statement.execute();

            
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {
        try {
            Connection connection = new PostgresqlConnection().getConnection();
            String sql = "DELETE Alocação WHERE id_Alocacao = ?";
        
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            
            connection.close();
            
        }catch(Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Alocação consultarPorId(Integer id) throws PersistenciaException {
        Alocação alocação = null;
        
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Alocação WHERE id_Alocacao = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    alocação = new Alocação();
                    
                    alocação.setIdAlocacao(resultSet.getInt("id_Alocacao"));
                    alocação.setDatAlocacao(resultSet.getDate("dat_Alocacao"));
                    alocação.setCpfProfessor(new ProfessorDAO().consultarPorCpf(resultSet.getString("cpf_Professor")));
                    alocação.setIdAmbiente(new AmbienteDAO().consultarPorId(resultSet.getInt("id_Ambiente")));
                    
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return alocação;
    }

    @Override
    public List<Alocação> listarTodos() throws PersistenciaException {
        List <Alocação> curriculoList = new ArrayList<Alocação>();
        
        Alocação alocação = null;
        
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Alocação";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    alocação = new Alocação();
                    
                    alocação.setIdAlocacao(resultSet.getInt("id_Alocacao"));
                    alocação.setDatAlocacao(resultSet.getDate("dat_Alocacao"));
                    alocação.setCpfProfessor(new ProfessorDAO().consultarPorCpf(resultSet.getString("cpf_Professor")));
                    alocação.setIdAmbiente(new AmbienteDAO().consultarPorId(resultSet.getInt("id_Ambiente")));
                    

                    curriculoList.add(alocação);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curriculoList;
    }
    
}
