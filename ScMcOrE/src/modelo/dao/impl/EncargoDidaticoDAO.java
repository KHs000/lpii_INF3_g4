/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.impl;

import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelo.dao.GenericDAO;
import modelo.dao.IEncargoDidaticoDAO;
import modelo.domain.EncargoDidático;
import db.PostgresqlConnection;
import java.util.ArrayList;

/**
 *
 * @author helde
 */
public class EncargoDidaticoDAO implements IEncargoDidaticoDAO {

    @Override
    public Integer inserir(EncargoDidático obj) throws PersistenciaException {
        Integer id = null;

        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "INSERT INTO Encargo Didático (hor_Inicio, hor_Fim, dia_Semana, cpf_Professor, id_Ambiente, id_Curso, id_Disciplina, idt_Relacao) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?) RETURNING id_Encargo";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setTime(1, obj.getHorInicio());
            statement.setTime(2, obj.getHorFim());
            statement.setShort(3, obj.getDiaSemana());
            statement.setString(4, obj.getCpfProfessor().getCpfProfessor());
            statement.setInt(5, obj.getIdAmbiente().getIdAmbiente());
            statement.setInt(6, obj.getRelaçãoCursoDisciplina().getCurso().getIdCurso());
            statement.setInt(7, obj.getRelaçãoCursoDisciplina().getDisciplina().getIdDisciplina());
            statement.setInt(8, obj.getRelaçãoCursoDisciplina().getRelaçãoCursoDisciplinaPK().getIdtRelacao());
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                obj.setIdEncargo(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(EncargoDidático obj) throws PersistenciaException {
        try{
            Connection connection = new PostgresqlConnection().getConnection();
            String sql = "UPDATE Encargo Didático SET hor_Inicio = ?, hor_Fim = ?, dia_Semana = ?, cpf_Professor = ?, id_Ambiente = ?, id_Curso = ?, id_Disciplina = ?, idt_Relacao = ? WHERE id_Encargo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setTime(1, obj.getHorInicio());
            statement.setTime(2, obj.getHorFim());
            statement.setShort(3, obj.getDiaSemana());
            statement.setString(4, obj.getCpfProfessor().getCpfProfessor());
            statement.setInt(5, obj.getIdAmbiente().getIdAmbiente());
            statement.setInt(6, obj.getRelaçãoCursoDisciplina().getCurso().getIdCurso());
            statement.setInt(7, obj.getRelaçãoCursoDisciplina().getDisciplina().getIdDisciplina());
            statement.setInt(8, obj.getRelaçãoCursoDisciplina().getRelaçãoCursoDisciplinaPK().getIdtRelacao());
            statement.setInt(9, obj.getIdEncargo());
            
            statement.execute();

            
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
        
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {
        try {
            Connection connection = new PostgresqlConnection().getConnection();
            String sql = "DELETE FROM Encargo Didático WHERE id_Encargo = ?";
        
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
    public EncargoDidático consultarPorId(Integer id) throws PersistenciaException {
        EncargoDidático encargo = null;
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Encargo Didático WHERE id_Encargo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    encargo = new EncargoDidático();
                    
                    encargo.setIdEncargo(resultSet.getInt("id_Encargo"));
                    encargo.setHorInicio(resultSet.getTime("hor_Inicio"));
                    encargo.setHorFim(resultSet.getTime("hor_Fim"));
                    encargo.setDiaSemana(resultSet.getShort("dia_Semana"));
                    encargo.setCpfProfessor(new ProfessorDAO().consultarPorId(resultSet.getInt("cpf_Professor")));
                    encargo.setIdAmbiente(new AmbienteDAO().consultarPorId(resultSet.getInt("id_Ambiente")));
                    encargo.setIdCurso(new CursoDAO().consultarPorId(resultSet.getInt("id_Curso")));
                    encargo.setIdDisciplina(new DisciplinaDAO().consultarPorId(resultSet.getInt("id_Disciplina")));
                    encargo.setIdtRelacao(new ModuloDAO().consultarPorId(resultSet.getInt("idt_Relacao")));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return encargo;
    }

    @Override
    public List<EncargoDidático> listarTodos() throws PersistenciaException {
        List <EncargoDidático> encargoList = new ArrayList<EncargoDidático>();
        EncargoDidático encargo = null;
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Encargo Didático";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    encargo = new EncargoDidático();
                    encargo.setIdEncargo(resultSet.getInt("id_Encargo"));
                    encargo.setHorInicio(resultSet.getTime("hor_Inicio"));
                    encargo.setHorFim(resultSet.getTime("hor_Fim"));
                    encargo.setDiaSemana(resultSet.getShort("dia_Semana"));
                    encargo.setCpfProfessor(new ProfessorDAO().consultarPorId(resultSet.getInt("cpf_Professor")));
                    encargo.setIdAmbiente(new AmbienteDAO().consultarPorId(resultSet.getInt("id_Ambiente")));
                    encargo.setIdCurso(new CursoDAO().consultarPorId(resultSet.getInt("id_Curso")));
                    encargo.setIdDisciplina(new DisciplinaDAO().consultarPorId(resultSet.getInt("id_Disciplina")));
                    encargo.setRelaçãoCursoDisciplina((new ModuloDAO().consultarPorId(resultSet.getInt("idt_Relacao"))));

                    encargoList.add(encargo);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return encargoList;
    }
    
    
    
}
