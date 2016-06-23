
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUnidadeDeEnsinoDAO;
import br.cefetmg.inf.model.domain.UnidadeDeEnsino;
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
public class UnidadeDeEnsinoDAO implements IUnidadeDeEnsinoDAO{

    @Override
    public UnidadeDeEnsino consultarPorNome(String nome) throws PersistenciaException {
        
        UnidadeDeEnsino unidadeDeEnsino = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String sql = "SELECT * FROM Und_Ensino WHERE nome = " + nome;
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                unidadeDeEnsino = new UnidadeDeEnsino();
                unidadeDeEnsino.setId(resultSet.getLong("id"));
                unidadeDeEnsino.setNome(resultSet.getString("nome"));
                unidadeDeEnsino.setSigla(resultSet.getString("sigla"));
                unidadeDeEnsino.setTelefone(resultSet.getString("telefone"));
                unidadeDeEnsino.setEndereco(resultSet.getString("endereco"));
                unidadeDeEnsino.setEmail(resultSet.getString("email"));
                unidadeDeEnsino.setUrl(resultSet.getString("url"));
            }
            connection.close();
        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return unidadeDeEnsino;
        
    }

    @Override
    public Long inserir(UnidadeDeEnsino unidadeDeEnsino) throws PersistenciaException {
        
        Long id = null;

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Und_Ensino (nome, sigla, endereco, telefone, email, url) " + 
                    "VALUES(?, ?, ?, ?, ?, ?) RETURNING id";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, unidadeDeEnsino.getNome());
            statement.setString(2, unidadeDeEnsino.getSigla());
            statement.setString(3, unidadeDeEnsino.getEndereco());
            statement.setString(4, unidadeDeEnsino.getTelefone());
            statement.setString(5, unidadeDeEnsino.getEmail());
            statement.setString(6, unidadeDeEnsino.getUrl());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id"));
                unidadeDeEnsino.setId(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(UnidadeDeEnsino unidadeDeEnsino) throws PersistenciaException {
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Und_Ensino " +
                            " SET nome = ?, " +
                            "     sigla = ?," +
                            "     endereco = ?," +
                            "     telefone = ?" +
                            "     email = ?" +
                            "     url = ?" +
                            " WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, unidadeDeEnsino.getNome());
            statement.setString(2, unidadeDeEnsino.getSigla());
            statement.setString(3, unidadeDeEnsino.getEndereco());
            statement.setString(4, unidadeDeEnsino.getTelefone());
            statement.setString(5, unidadeDeEnsino.getEmail());
            statement.setString(6, unidadeDeEnsino.getUrl());
            statement.setLong(7, unidadeDeEnsino.getId());

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

            String sql = "DELETE FROM Und_Ensino WHERE id = ?";

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
    public UnidadeDeEnsino consultarPorId(Long id) throws PersistenciaException {
        UnidadeDeEnsino unidadeDeEnsino = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Und_Ensino WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    unidadeDeEnsino = new UnidadeDeEnsino();
                    unidadeDeEnsino.setId(resultSet.getLong("id"));
                    unidadeDeEnsino.setNome(resultSet.getString("nome"));
                    unidadeDeEnsino.setSigla(resultSet.getString("sigla"));
                    unidadeDeEnsino.setEndereco(resultSet.getString("endereco"));
                    unidadeDeEnsino.setTelefone(resultSet.getString("telefone"));
                    unidadeDeEnsino.setEmail(resultSet.getString("email"));
                    unidadeDeEnsino.setUrl(resultSet.getString("url"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return unidadeDeEnsino;
    }

    @Override
    public List<UnidadeDeEnsino> listarTodos() throws PersistenciaException {
        List<UnidadeDeEnsino> unidadeList = new ArrayList<UnidadeDeEnsino>();

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Und_Ensino";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    UnidadeDeEnsino unidadeDeEnsino = new UnidadeDeEnsino();
                    unidadeDeEnsino.setId(resultSet.getLong("id"));
                    unidadeDeEnsino.setNome(resultSet.getString("nome"));
                    unidadeDeEnsino.setSigla(resultSet.getString("sigla"));
                    unidadeDeEnsino.setEndereco(resultSet.getString("endereco"));
                    unidadeDeEnsino.setTelefone(resultSet.getString("telefone"));
                    unidadeDeEnsino.setEmail(resultSet.getString("email"));
                    unidadeDeEnsino.setUrl(resultSet.getString("url"));

                    unidadeList.add(unidadeDeEnsino);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return unidadeList;
    }
    
}
