package WEB-INF.classes.br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.domain.Disciplina;
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
public class DisciplinaDAO implements IDisciplinaDAO{

    public Disciplina consultarPorNome(String nome) throws PersistenciaException {
        Disciplina disciplina = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Disciplina WHERE nom_Disciplina = " + nome;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    disciplina = new Disciplina();
                    disciplina.setId(resultSet.getLong("id_Disciplina"));
                    disciplina.setNome(resultSet.getString("nom_Disciplina"));
                    disciplina.setCargaHoraria(resultSet.getInt("qtd_Carga_Horaria"));
                    disciplina.setDescricao(resultSet.getString("des_Ementa"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return disciplina;
    }

    public Long inserir(Disciplina disciplina) throws PersistenciaException {
        
        Long id = null;

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Disciplina (nom_Disciplina, qtd_Carga_Horaria, des_Ementa) " + 
                    "VALUES(" + disciplina.getNome() + ", " + disciplina.getCargaHoraria() + ", "
                    + disciplina.getDescricao() + ") RETURNING id_Disciplina";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, disciplina.getNome());
            statement.setLong(2, disciplina.getCargaHoraria());
            statement.setString(3, disciplina.getDescricao());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id_Disciplina"));
                disciplina.setId(id);
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
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Disciplina " +
                            "SET nom_Disciplina = ?, " +
                            "    qtd_Carga_Horaria = ?," +
                            "    des_Ementa = ?" +
                            " WHERE id_Disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, disciplina.getNome());
            statement.setInt(2, disciplina.getCargaHoraria());
            statement.setString(3, disciplina.getDescricao());
            statement.setLong(4, disciplina.getId());

            statement.execute();

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }    
    }

    public void excluir(Long id) throws PersistenciaException {
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Disciplina WHERE id_Disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }   
    }

    public Disciplina consultarPorId(Long id) throws PersistenciaException {
        
        Disciplina disciplina = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Disciplina WHERE id_Disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    disciplina = new Disciplina();
                    disciplina.setId(resultSet.getLong("id_Disciplina"));
                    disciplina.setNome(resultSet.getString("nom_Disciplina"));
                    disciplina.setCargaHoraria(resultSet.getInt("qtd_Carga_Horaria"));
                    disciplina.setDescricao(resultSet.getString("des_Ementa"));
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
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Disciplina";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Disciplina disciplina = new Disciplina();
                    disciplina.setId(resultSet.getLong("id_Disciplina"));
                    disciplina.setNome(resultSet.getString("nom_Disciplina"));
                    disciplina.setCargaHoraria(resultSet.getInt("qtd_Carga_Horaria"));
                    disciplina.setDescricao(resultSet.getString("des_Ementa"));

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
