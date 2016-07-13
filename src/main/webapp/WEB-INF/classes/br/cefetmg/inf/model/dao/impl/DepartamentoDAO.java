
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDepartamentoDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
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
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String sql = "SELECT * FROM Departamento WHERE nom_Departamento = " + nome;
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                departamento = new Departamento();
                departamento.setId(resultSet.getLong("id_Departamento"));
                departamento.setNome(resultSet.getString("nom_Departamento"));
                //departamento.setUnidadeDeEnsino(resultSet.getObject("Und_Ensino")); Und_Ensino DEVE SER CONVERTIDO PARA OBJECT
            }
            connection.close();
        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return departamento;
    }

    @Override
    public Long inserir(Departamento departamento) throws PersistenciaException {
        
        Long id = null;

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Departamento (nom_Departamento) " + 
                    "VALUES(" + departamento.getNome() + ") RETURNING id_Departamento";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, departamento.getNome());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id_Departamento"));
                departamento.setId(id);
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
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Departamento " +
                            "SET nom_Departamento = ? " +
                            "WHERE id_Departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, departamento.getNome());
            statement.setLong(2, departamento.getId());

            statement.execute();

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }      
    }

    @Override
    public void excluir(Long id) throws PersistenciaException {
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

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
    public Departamento consultarPorId(Long id) throws PersistenciaException {
        
        Departamento departamento = null;
        
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Departamento WHERE id_Departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    departamento = new Departamento();
                    departamento.setId(resultSet.getLong("id_Departamento"));
                    departamento.setNome(resultSet.getString("nom_Departamento"));
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
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Departamento";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Departamento departamento = new Departamento();
                    departamento.setId(resultSet.getLong("id_Departamento"));
                    departamento.setNome(resultSet.getString("nom_Departamento"));

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
