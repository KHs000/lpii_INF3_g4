
package modelo.dao.impl;

import modelo.dao.IDepartamentoDAO;
import modelo.domain.Departamento;
import db.PostgresqlConnection;
import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class DepartamentoDAO implements IDepartamentoDAO{

    @Override
    public Departamento consultarPorNome(String nome) throws PersistenciaException {
        
        Departamento departamento = null;
        try {
            Connection connection = new PostgresqlConnection().getConnection();
            
            String sql = "SELECT * FROM Departamento WHERE nom_Departamento = " + nome;
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                departamento = new Departamento();
                departamento.setIdDepartamento(resultSet.getInt("id_Departamento"));
                departamento.setNomDepartamento(resultSet.getString("nom_Departamento"));
                departamento.setIdUnidade(new UnidadedeEnsinoDAO().consultaPorId(resultSet.getInt("id_Unidade")));
            }
            connection.close();
        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return departamento;
    }

    @Override
    public Integer inserir(Departamento departamento) throws PersistenciaException {
        
        Integer id = null;

        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "INSERT INTO Departamento (nom_Departamento, id_Unidade) " + 
                    "VALUES( ? , ?) RETURNING id_Departamento";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, departamento.getNomDepartamento());
            statement.setInt(2, departamento.getIdUnidade().getIdUnidade());
            
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Integer(resultSet.getInt("id_Departamento"));
                departamento.setIdDepartamento(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;  
    }

    @Override
    public void atualizar(Departamento departamento) throws PersistenciaException {
        
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "UPDATE Departamento " +
                            "SET nom_Departamento = ?, id_Unidade = ? " +
                            "WHERE id_Departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, departamento.getNomDepartamento());
            statement.setInt(2, departamento.getIdUnidade().getIdUnidade());
            statement.setLong(3, departamento.getIdDepartamento());

            statement.execute();

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }      
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "DELETE FROM Departamento WHERE id_Departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }    
    }

    @Override
    public Departamento consultarPorId(Integer id) throws PersistenciaException {
        
        Departamento departamento = null;
        
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Departamento WHERE id_Departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    departamento = new Departamento();
                    departamento.setIdDepartamento(resultSet.getInt("id_Departamento"));
                    departamento.setNomDepartamento(resultSet.getString("nom_Departamento"));
                    departamento.setIdUnidade(new UnidadedeEnsinoDAO().consultaPorId(resultSet.getInt("id_Unidade")));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return departamento;   
    }

    @Override
    public List<Departamento> listarTodos() throws PersistenciaException {
        
        List<Departamento> departamentoList = new ArrayList<Departamento>();
        Departamento departamento = null;
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Departamento";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    departamento = new Departamento();
                    departamento.setIdDepartamento(resultSet.getInt("id_Departamento"));
                    departamento.setNomDepartamento(resultSet.getString("nom_Departamento"));
                    departamento.setIdUnidade(new UnidadedeEnsinoDAO().consultaPorId(resultSet.getInt("id_Unidade")));

                    departamentoList.add(departamento);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }

        return departamentoList; 
    }
    
}
