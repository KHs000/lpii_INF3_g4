
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ITurmaDAO;
import br.cefetmg.inf.model.domain.Turma;
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
public class TurmaDAO implements ITurmaDAO{

    @Override
    public Turma consultarPorNome(String nome) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long inserir(Turma turma) throws PersistenciaException {
        
        Long id = null;

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO turma (vaga, inicio, termino) " + "VALUES(?, ?, ?) RETURNING id";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, turma.getVagasLimite());
            statement.setDate(2, turma.getInicio());
            statement.setDate(3, turma.getTermino());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id"));
                turma.setId(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(Turma turma) throws PersistenciaException {
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE turma " +
                            " SET vagasLimite = ?, " +
                            "     inicio = ?," +
                            "     termino = ?," +
                            " WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, turma.getVagasLimite());
            statement.setDate(2, turma.getInicio());
            statement.setDate(3, turma.getTermino());
            statement.setLong(4, turma.getId());

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

            String sql = "DELETE FROM turma WHERE id = ?";

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
    public Turma consultarPorId(Long id) throws PersistenciaException {
        
        Turma turma = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM turma WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    turma = new Turma();
                    turma.setId(resultSet.getLong("id"));
                    turma.setVagasLimite(resultSet.getInt("vagasLimite"));
                    turma.setInicio(resultSet.getDate("inicio"));
                    turma.setTermino(resultSet.getDate("termino"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return turma;
        
    }

    @Override
    public List<Turma> listarTodos() throws PersistenciaException {
        
        List<Turma> turmaList = new ArrayList<Turma>();

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM turma";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Turma turma = new Turma();
                    turma.setId(resultSet.getLong("id"));
                    turma.setVagasLimite(resultSet.getInt("vagasLimite"));
                    turma.setInicio(resultSet.getDate("inicio"));
                    turma.setTermino(resultSet.getDate("termino"));

                    turmaList.add(turma);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return turmaList;
        
    }
    
}
