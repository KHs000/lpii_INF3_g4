/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.impl;

import db.PostgresqlConnection;
import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.IModuloDAO;
import modelo.domain.Modulo;

/**
 *
 * @author DASJ
 */
class ModuloDAO implements IModuloDAO {

    public ModuloDAO() {
    }

    @Override
    public Integer inserir(Modulo obj) throws PersistenciaException {
        
        Integer id = null;

        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "INSERT INTO Relação CursoDisciplina (id_Curso, id_Disciplina, idt_Serie, idt_Modulo) " + "VALUES(?, ?, ?, ?) RETURNING idt_Relacao";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, obj.getCurso().getIdCurso());
            statement.setInt(2, obj.getDisciplina().getIdDisciplina());
            statement.setShort(3, obj.getIdtSerie());
            statement.setShort(4, obj.getIdtModulo());
                        
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                obj.getRelaçãoCursoDisciplinaPK().setIdtRelacao(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
        
    }

    @Override
    public void atualizar(Modulo obj) throws PersistenciaException {
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "UPDATE Relação CursoDisciplina SET id_Curso = ? , id_Disciplina = ? , idt_Serie = ? , idt_Modulo = ? WHERE idt_Relacao = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, obj.getCurso().getIdCurso());
            statement.setInt(2, obj.getDisciplina().getIdDisciplina());
            statement.setShort(3, obj.getIdtSerie());
            statement.setShort(4, obj.getIdtModulo());
            statement.setInt(5, obj.getRelaçãoCursoDisciplinaPK().getIdtRelacao());
                        
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
            String sql = "DELETE FROM Relação CursoDisciplina WHERE idt_Relacao = ?";
        
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
    public Modulo consultarPorId(Integer id) throws PersistenciaException {
        Modulo modulo = null;
        
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Relação CursoDisciplina WHERE idt_Relacao = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    modulo = new Modulo();
                    
                    modulo.setCurso(new CursoDAO().consultarPorId(resultSet.getInt("id_Curso")));
                    modulo.setDisciplina(new DisciplinaDAO().consultarPorId(resultSet.getInt("id_Disciplina")));
                    modulo.setIdtSerie(resultSet.getShort("idt_Serie"));
                    modulo.setIdtModulo(resultSet.getShort("idt_Modulo"));
                    
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return modulo;
    }

    @Override
    public List<Modulo> listarTodos() throws PersistenciaException {
        List <Modulo> moduloList = new ArrayList<Modulo>();
        Modulo modulo = null;
        
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Relação CursoDisciplina";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    modulo = new Modulo();
                    
                    modulo.setCurso(new CursoDAO().consultarPorId(resultSet.getInt("id_Curso")));
                    modulo.setDisciplina(new DisciplinaDAO().consultarPorId(resultSet.getInt("id_Disciplina")));
                    modulo.setIdtSerie(resultSet.getShort("idt_Serie"));
                    modulo.setIdtModulo(resultSet.getShort("idt_Modulo"));

                    moduloList.add(modulo);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return moduloList;
    }
    
}
