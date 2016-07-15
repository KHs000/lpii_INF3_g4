package modelo.dao.impl;

import modelo.domain.Disciplina;
import db.PostgresqlConnection;
import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.IDisciplinaDAO;

/**
 *
 * @author Felipe Rabelo
 */
public class DisciplinaDAO implements IDisciplinaDAO {

    public Disciplina consultarPorNome(String nome) throws PersistenciaException {
        Disciplina disciplina = null;
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Disciplina WHERE nom_Disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    disciplina = new Disciplina();
                    disciplina.setIdDisciplina(resultSet.getInt("id_Disciplina"));
                    disciplina.setNomDisciplina(resultSet.getString("nom_Disciplina"));
                    disciplina.setQtdCargaHoraria(resultSet.getShort("qtd_Carga_Horaria"));
                    disciplina.setDesEmenta(resultSet.getString("des_Ementa"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return disciplina;
    }

    public Integer inserir(Disciplina disciplina) throws PersistenciaException {
        
        Integer id = null;

        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "INSERT INTO Disciplina (nom_Disciplina, qtd_Carga_Horaria, des_Ementa) " + 
                    "VALUES( ?, ?, ?) RETURNING id_Disciplina";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, disciplina.getNomDisciplina());
            statement.setShort(2, disciplina.getQtdCargaHoraria());
            statement.setString(3, disciplina.getDesEmenta());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Integer(resultSet.getInt("id_Disciplina"));
                disciplina.setIdDisciplina(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    public void atualizar(Disciplina disciplina) throws PersistenciaException {
        
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "UPDATE Disciplina " +
                            "SET nom_Disciplina = ?, " +
                            "    qtd_Carga_Horaria = ?," +
                            "    des_Ementa = ?" +
                            " WHERE id_Disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, disciplina.getNomDisciplina());
            statement.setShort(2, disciplina.getQtdCargaHoraria());
            statement.setString(3, disciplina.getDesEmenta());
            statement.setInt(4, disciplina.getIdDisciplina());

            statement.execute();

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }    
    }

    public void excluir(Integer id) throws PersistenciaException {
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "DELETE FROM Disciplina WHERE id_Disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }   
    }

    public Disciplina consultarPorId(Integer id) throws PersistenciaException {
        
        Disciplina disciplina = null;
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Disciplina WHERE id_Disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    disciplina = new Disciplina();
                    disciplina.setIdDisciplina(resultSet.getInt("id_Disciplina"));
                    disciplina.setNomDisciplina(resultSet.getString("nom_Disciplina"));
                    disciplina.setQtdCargaHoraria(resultSet.getShort("qtd_Carga_Horaria"));
                    disciplina.setDesEmenta(resultSet.getString("des_Ementa"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return disciplina;
    }  
    
    public List<Disciplina> listarTodos() throws PersistenciaException {

        List<Disciplina> disciplinaList = new ArrayList<Disciplina>();
        
        Disciplina disciplina = null;
        
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Disciplina";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    disciplina = new Disciplina();
                    
                    disciplina.setIdDisciplina(resultSet.getInt("id_Disciplina"));
                    disciplina.setNomDisciplina(resultSet.getString("nom_Disciplina"));
                    disciplina.setQtdCargaHoraria(resultSet.getShort("qtd_Carga_Horaria"));
                    disciplina.setDesEmenta(resultSet.getString("des_Ementa"));

                    disciplinaList.add(disciplina);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }

        return disciplinaList;
    }
}
