
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ICursoDAO;
import br.cefetmg.inf.model.domain.Curso;
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
public class CursoDAO implements ICursoDAO {

    @Override
    public Curso consultarPorNome(String nome) throws PersistenciaException {
        
        Curso curso = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM curso WHERE nome = " + nome;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    curso = new Curso();
                    curso.setId(resultSet.getLong("id"));
                    curso.setNome(resultSet.getString("nome"));
                    curso.setCargaHoraria(resultSet.getInt("cargaHoraria"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curso;
    }

    @Override
    public Long inserir(Curso curso) throws PersistenciaException {
        
        Long id = null;

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO curso (nome, cargaHoraria) " + 
                    "VALUES(" + curso.getNome() + ", " + curso.getCargaHoraria() + ") RETURNING id";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, curso.getNome());
            statement.setLong(2, curso.getCargaHoraria());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id"));
                curso.setId(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(Curso curso) throws PersistenciaException {
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE curso " +
                            " SET nome = ?, " +
                            "     cargaHoraria = ?," +
                            " WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, curso.getNome());
            statement.setLong(2, curso.getCargaHoraria());
            statement.setLong(5, curso.getId());

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

            String sql = "DELETE FROM curso WHERE id = ?";

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
    public Curso consultarPorId(Long id) throws PersistenciaException {
        Curso curso = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    curso = new Curso();
                    curso.setId(resultSet.getLong("id"));
                    curso.setNome(resultSet.getString("nome"));
                    curso.setCargaHoraria(resultSet.getInt("cargaHoraria"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curso;
    }

    @Override
    public List<Curso> listarTodos() throws PersistenciaException {
        
        List<Curso> cursoList = new ArrayList<Curso>();
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM curso";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Curso curso = new Curso();
                    curso.setId(resultSet.getLong("id"));
                    curso.setNome(resultSet.getString("nome"));
                    curso.setCargaHoraria(resultSet.getInt("cargaHoraria"));

                    cursoList.add(curso);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return cursoList;
    }
    
}
