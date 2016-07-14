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

    public String Inserir(Professor professor) throws PersistenciaException {

        String id = null;

        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Professor (nom_Professor, cpf_Professor, log_Professor, pwd_Professor) " + "VALUES(?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, professor.getNomProfessor());
            statement.setString(2, professor.getCpfProfessor());
            statement.setString(3, professor.getLogProfessor());
            statement.setString(4, professor.getPwdProfessor());
            id=professor.getCpfProfessor();
            ResultSet resultSet = statement.executeQuery();

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    public void atualizar(Professor professor) throws PersistenciaException {

        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Professor " +
                            " SET cpf_Professor = ?, " +
                            "     nom_Professor = ?," +
                            "     log_Professor = ?," +
                            "     pwd_Professor = ?" +
                            " WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,professor.getCpfProfessor());
            statement.setString(2,professor.getNomProfessor());
            statement.setString(3, professor.getLogProfessor());
            statement.setString(4, professor.getPwdProfessor());
            statement.setString(5, professor.getCpfProfessor());

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
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM professor WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

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
    public Professor consultarPorId(Long id) throws PersistenciaException {
        Professor professor = null;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Professor WHERE cpf_Professor = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

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

    public Long inserir(Professor obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professor consultarPorId(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
