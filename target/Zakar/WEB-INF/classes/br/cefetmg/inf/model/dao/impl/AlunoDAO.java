package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAlunoDAO;
import br.cefetmg.inf.model.domain.Aluno;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO implements IAlunoDAO {

    @Override
    public Long inserir(Aluno aluno) throws PersistenciaException {

        Long id = null;

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO aluno (nome, cpf, endereco, telefone) " + "VALUES(?, ?, ?, ?) RETURNING id";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, aluno.getNome());
            statement.setLong(2, aluno.getCpf());
            statement.setString(3, aluno.getEndereco());
            statement.setString(4, aluno.getTelefone());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id"));
                aluno.setId(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(Aluno aluno) throws PersistenciaException {

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE aluno " +
                            " SET nome = ?, " +
                            "     cpf = ?," +
                            "     endereco = ?," +
                            "     telefone = ?" +
                            " WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, aluno.getNome());
            statement.setLong(2, aluno.getCpf());
            statement.setString(3, aluno.getEndereco());
            statement.setString(4, aluno.getTelefone());
            statement.setLong(5, aluno.getId());

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

            String sql = "DELETE FROM aluno WHERE id = ?";

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
    public List<Aluno> listarTodos() throws PersistenciaException {

        List<Aluno> alunoList = new ArrayList<Aluno>();

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM aluno";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Aluno aluno = new Aluno();
                    aluno.setId(resultSet.getLong("id"));
                    aluno.setNome(resultSet.getString("nome"));
                    aluno.setCpf(resultSet.getLong("cpf"));
                    aluno.setEndereco(resultSet.getString("endereco"));
                    aluno.setTelefone(resultSet.getString("telefone"));

                    alunoList.add(aluno);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return alunoList;
    }

    @Override
    public Aluno consultarPorId(Long id) throws PersistenciaException {
        Aluno aluno = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM aluno WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    aluno = new Aluno();
                    aluno.setId(resultSet.getLong("id"));
                    aluno.setNome(resultSet.getString("nome"));
                    aluno.setCpf(resultSet.getLong("cpf"));
                    aluno.setEndereco(resultSet.getString("endereco"));
                    aluno.setTelefone(resultSet.getString("telefone"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return aluno;
    }

    @Override
    public Aluno consultarPorNome(String nome) throws PersistenciaException {

        Aluno aluno = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM aluno WHERE nome = " + nome;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    aluno = new Aluno();
                    aluno.setId(resultSet.getLong("id"));
                    aluno.setNome(resultSet.getString("nome"));
                    aluno.setCpf(resultSet.getLong("cpf"));
                    aluno.setEndereco(resultSet.getString("endereco"));
                    aluno.setTelefone(resultSet.getString("telefone"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return aluno;
    }
}
