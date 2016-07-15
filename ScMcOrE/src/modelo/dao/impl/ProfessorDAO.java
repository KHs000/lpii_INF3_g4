package modelo.dao.impl;

import modelo.dao.IProfessorDAO;
import db.ConnectionManager;
import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.domain.Professor;

public class ProfessorDAO implements IProfessorDAO {

    @Override
    public void inserir(Professor professor) throws PersistenciaException {

        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Professor (nom_Professor, cpf_Professor, log_Professor, pwd_Professor) " + "VALUES(?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, professor.getNomProfessor());
            statement.setString(2, professor.getCpfProfessor());
            statement.setString(3, professor.getLogProfessor());
            statement.setString(4, professor.getPwdProfessor());

            statement.execute();

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    public void atualizar(Professor professor) throws PersistenciaException {

        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Professor " +
                            " SET " +
                            "     nom_Professor = ?," +
                            "     log_Professor = ?," +
                            "     pwd_Professor = ?" +
                            " WHERE cpf_Professor = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

           
            statement.setString(1,professor.getNomProfessor());
            statement.setString(2, professor.getLogProfessor());
            statement.setString(3, professor.getPwdProfessor());
            statement.setString(4, professor.getCpfProfessor());

            statement.execute();

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public void excluir(String cpf) throws PersistenciaException {

        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM professor WHERE cpf_Professor = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, cpf);

            statement.execute();
            connection.close();
        }catch(Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }

    }

    public List<Professor> listarTodos() throws PersistenciaException {

        List<Professor> professorList = new ArrayList<Professor>();

        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Professor";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Professor professor = new Professor();
                    professor.setCpfProfessor(resultSet.getString("cpf_Professor"));
                    professor.setNomProfessor(resultSet.getString("nom_Professor"));
                    professor.setLogProfessor(resultSet.getString("log_Professor"));
                    professor.setPwdProfessor(resultSet.getString("pwd_Professor"));

                    professorList.add(professor);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return professorList;
    }

    @Override
    public Professor consultarPorCpf(String cpf) throws PersistenciaException {
        Professor professor = null;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Professor WHERE cpf_Professor = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    professor = new Professor();
                    professor.setCpfProfessor(resultSet.getString("cpf_Professor"));
                    professor.setNomProfessor(resultSet.getString("nom_Professor"));
                    professor.setLogProfessor(resultSet.getString("log_Professor"));
                    professor.setPwdProfessor(resultSet.getString("pwd_Professor"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return professor;
    }

    @Override
    public Professor consultarPorNome(String nome) throws PersistenciaException {

        Professor professor = null;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Professor WHERE nom_Professor = " + nome;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    professor = new Professor();
                    professor.setCpfProfessor(resultSet.getString("cpf_Professor"));
                    professor.setNomProfessor(resultSet.getString("nom_Professor"));
                    professor.setLogProfessor(resultSet.getString("log_Professor"));
                    professor.setPwdProfessor(resultSet.getString("pwd_Professor"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return professor;
    }

    
    
}
