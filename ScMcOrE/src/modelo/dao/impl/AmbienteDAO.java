/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.impl;

import db.PostgresqlConnection;
import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.IAmbienteDAO;
import modelo.domain.AmbientesdeEnsino;

/**
 *
 * @author DASJ
 */
public class AmbienteDAO implements IAmbienteDAO {
    @Override
    public Integer inserir(AmbientesdeEnsino obj) throws PersistenciaException {
        Integer id = null;

        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "INSERT INTO Ambientes de Ensino (nom_Ambiente, des_Ambiente, id_Unidade) " + "VALUES(?, ?, ?, ?) RETURNING id_Ambiente";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, obj.getNomAmbiente());
            statement.setString(2, obj.getDesAmbiente());
            statement.setInt(3, obj.getIdUnidade().getIdUnidade());
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_Ambiente");
                obj.setIdAmbiente(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(AmbientesdeEnsino obj) throws PersistenciaException {
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "UPDATE Ambientes de Ensino (nom_Ambiente, des_Ambiente, id_Unidade) " + "VALUES(?, ?, ?, ?) RETURNING id_Ambiente";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, obj.getNomAmbiente());
            statement.setString(2, obj.getDesAmbiente());
            statement.setInt(3, obj.getIdUnidade().getIdUnidade());
            
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
             String sql = "DELETE Ambiente de Ensino WHERE id_Ambiente = ?";

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
    public AmbientesdeEnsino consultarPorId(Integer id) throws PersistenciaException {
        AmbientesdeEnsino ambiente = null;
        
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Ambiente de Ensino WHERE id_Ambiente = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    ambiente = new AmbientesdeEnsino();
                    
                    ambiente.setNomAmbiente(resultSet.getInt("nom_Ambiente"));
                    ambiente.setDesAmbiente(resultSet.getString("des_Ambiente"));
                    ambiente.setIdAmbiente(resultSet.getInt("id_Ambiente"));
                    ambiente.setIdUnidade(new UnidadedeEnsinoDAO().consultaPorId(resultSet.getInt("id_Unidade")));
                    
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return ambiente;
    }

    @Override
    public List<AmbientesdeEnsino> listarTodos() throws PersistenciaException {
        List <AmbientesdeEnsino> curriculoList = new ArrayList<AmbientesdeEnsino>();
        
        AmbientesdeEnsino ambiente = null;
        
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Ambientes de Ensino";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    ambiente = new AmbientesdeEnsino();
                    
                    ambiente.setNomAmbiente(resultSet.getInt("nom_Ambiente"));
                    ambiente.setDesAmbiente(resultSet.getString("des_Ambiente"));
                    ambiente.setIdAmbiente(resultSet.getInt("id_Ambiente"));
                    ambiente.setIdUnidade(new UnidadedeEnsinoDAO().consultaPorId(resultSet.getInt("id_Unidade")));
                    

                    curriculoList.add(ambiente);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curriculoList;
    }
    
}
