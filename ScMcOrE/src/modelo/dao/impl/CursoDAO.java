
package modelo.dao.impl;

import modelo.dao.ICursoDAO;
import modelo.domain.Curso;
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
public class CursoDAO implements ICursoDAO {

    @Override
    public Curso consultarPorNome(String nome) throws PersistenciaException {
        
        Curso curso = null;
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Curso WHERE nom_Curso = " + nome;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    curso = new Curso();
                    curso.setIdCurso(resultSet.getInt("id_Curso"));
                    curso.setNomCurso(resultSet.getString("nom_Curso"));
                    curso.setIdtRegime(resultSet.getString("idt_Regime"));
                    curso.setNvlEnsino(resultSet.getString("nvl_Ensino"));
                    curso.setIdtTurno(resultSet.getString("idt_Turno"));
                    curso.setCpfCoordenador(new ProfessorDAO().consultarPorCpf(resultSet.getString("cpf_Coordenador")));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curso;
    }

    @Override
    public Integer inserir(Curso curso) throws PersistenciaException {
        
        Integer id = null;

        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "INSERT INTO Curso (nom_Curso, idt_Regime, nvl_Ensino, idt_Turno, cpf_Coordenador) " + 
                    "VALUES('" + curso.getNomCurso() + "', '" + curso.getIdtRegime() + "', '" 
                    + curso.getNvlEnsino() + "', '" + curso.getIdtTurno() + "', '"
                    + curso.getCpfCoordenador().getCpfProfessor() + "') RETURNING id_Curso";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Integer(resultSet.getInt("id_Curso"));
                curso.setIdCurso(id);
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
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "UPDATE Curso " +
                            " SET nom_Curso = ?," +
                            "     idt_Regime = ?," +
                            "     nvl_Ensino = ?," +
                            "     idt_Turno = ?," +
                            "     cpf_Coordenador = ?" +
                            " WHERE id_Curso = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, curso.getNomCurso());
            statement.setString(2, curso.getIdtRegime());
            statement.setString(3, curso.getNvlEnsino());
            statement.setString(4, curso.getIdtTurno());
            statement.setString(5, curso.getCpfCoordenador().getCpfProfessor());
            statement.setInt(5, curso.getIdCurso());

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

            String sql = "DELETE FROM Curso WHERE id_Curso = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            connection.close();
        }catch(Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Curso consultarPorId(Integer id) throws PersistenciaException {
        Curso curso = null;
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Curso WHERE id_Curso = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    curso = new Curso();
                    curso.setIdCurso(resultSet.getInt("id_Curso"));
                    curso.setNomCurso(resultSet.getString("nom_Curso"));
                    curso.setIdtRegime(resultSet.getString("idt_Regime"));
                    curso.setNvlEnsino(resultSet.getString("nvl_Ensino"));
                    curso.setIdtTurno(resultSet.getString("idt_Turno"));
                    curso.setCpfCoordenador(new ProfessorDAO().consultarPorCpf(resultSet.getString("cpf_Coordenador")));
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
        Curso curso = null;
        
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Curso";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    curso = new Curso();
                    curso.setIdCurso(resultSet.getInt("id_Curso"));
                    curso.setNomCurso(resultSet.getString("nom_Curso"));
                    curso.setIdtRegime(resultSet.getString("idt_Regime"));
                    curso.setNvlEnsino(resultSet.getString("nvl_Ensino"));
                    curso.setIdtTurno(resultSet.getString("idt_Turno"));
                    curso.setCpfCoordenador(new ProfessorDAO().consultarPorCpf(resultSet.getString("cpf_Coordenador")));

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
