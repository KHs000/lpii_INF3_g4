
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

            String sql = "SELECT * FROM Curso WHERE nom_Curso = " + nome;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    curso = new Curso();
                    curso.setId(resultSet.getLong("id_Curso"));
                    curso.setNome(resultSet.getString("nom_Curso"));
                    curso.setRegime(resultSet.getString("idt_Regime"));
                    curso.setEnsino(resultSet.getString("nvl_Ensino"));
                    curso.setTurno(resultSet.getString("idt_Turno"));
                    curso.setCpf_coord(resultSet.getString("cpf_Coordenador"));
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

            String sql = "INSERT INTO Curso (nom_Curso, idt_Regime, nvl_Ensino, idt_Turno, cpf_Coordenador) " + 
                    "VALUES(" + curso.getNome() + ", " + curso.getRegime() + ", " 
                    + curso.getEnsino() + ", " + curso.getTurno() + ", "
                    + curso.getCpf_coord() + ") RETURNING id_Curso";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id_Curso"));
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

            String sql = "UPDATE Curso " +
                            " SET nom_Curso = ?," +
                            "     idt_Regime = ?," +
                            "     nvl_Ensino = ?," +
                            "     idt_Turno = ?," +
                            "     cpf_Coordenador = ?" +
                            " WHERE id_Curso = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getRegime());
            statement.setString(3, curso.getEnsino());
            statement.setString(4, curso.getTurno());
            statement.setString(5, curso.getCpf_coord());
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

            String sql = "DELETE FROM Curso WHERE id_Curso = ?";

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

            String sql = "SELECT * FROM Curso WHERE id_Curso = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    curso = new Curso();
                    curso.setId(resultSet.getLong("id_Curso"));
                    curso.setNome(resultSet.getString("nom_Curso"));
                    curso.setRegime(resultSet.getString("idt_Regime"));
                    curso.setEnsino(resultSet.getString("nvl_Ensino"));
                    curso.setTurno(resultSet.getString("idt_Turno"));
                    curso.setCpf_coord(resultSet.getString("cpf_Coordenador"));
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

            String sql = "SELECT * FROM Curso";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Curso curso = new Curso();
                    curso.setId(resultSet.getLong("id_Curso"));
                    curso.setNome(resultSet.getString("nom_Curso"));
                    curso.setRegime(resultSet.getString("idt_Regime"));
                    curso.setEnsino(resultSet.getString("nvl_Ensino"));
                    curso.setTurno(resultSet.getString("idt_Turno"));
                    curso.setCpf_coord(resultSet.getString("cpf_Coordenador"));

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
