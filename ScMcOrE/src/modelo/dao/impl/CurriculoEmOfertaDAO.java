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
import modelo.dao.ICurrículoEmOfertaDAO;
import modelo.domain.CurrículoemOferta;
/**
 *
 * @author helde
 */
public class CurriculoEmOfertaDAO implements ICurrículoEmOfertaDAO {

    public Integer inserir(CurrículoemOferta obj) throws PersistenciaException {
        Integer id = null;

        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "INSERT INTO Currículo em Oferta (id_Curso, id_Disciplina, idt_Relacao, idt_Periodo) " + "VALUES(?, ?, ?, ?) RETURNING id_Curriculo_Oferta";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, obj.getRelaçãoCursoDisciplina().getCurso().getIdCurso());
            statement.setInt(2, obj.getRelaçãoCursoDisciplina().getDisciplina().getIdDisciplina());
            statement.setInt(3, obj.getRelaçãoCursoDisciplina().getRelaçãoCursoDisciplinaPK().getIdtRelacao());
            statement.setInt(4, obj.getIdtPeriodo().getIdtPeriodo());
                        
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                obj.setIdCurriculoOferta(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(CurrículoemOferta obj) throws PersistenciaException {
        try{
            Connection connection = new PostgresqlConnection().getConnection();
            String sql = "UPDATE Currículo em Oferta SET id_Curso = ? , id_Disciplina = ? , idt_Relacao = ? , idt_Periodo = ? WHERE id_Curriculo_Oferta = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, obj.getRelaçãoCursoDisciplina().getCurso().getIdCurso());
            statement.setInt(2, obj.getRelaçãoCursoDisciplina().getDisciplina().getIdDisciplina());
            statement.setInt(3, obj.getRelaçãoCursoDisciplina().getRelaçãoCursoDisciplinaPK().getIdtRelacao());
            statement.setInt(4, obj.getIdtPeriodo().getIdtPeriodo());
            
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
            String sql = "DELETE FROM Currículo em Oferta WHERE id_Curriculo_Oferta = ?";
        
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
    public CurrículoemOferta consultarPorId(Integer id) throws PersistenciaException {
        
        CurrículoemOferta curriculo = null;
        
        try {
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Encargo Didático WHERE id_Curriculo_Oferta = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    curriculo = new CurrículoemOferta();
                    
                    curriculo.setIdtPeriodo(new PeríodoLetivoDAO().consultaPorId(resultSet.getInt("idt_Periodo")));
                    curriculo.setRelaçãoCursoDisciplina(new ModuloDAO().consultarPorId(resultSet.getInt("hor_Inicio")));
                    
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curriculo;
        
    }

    @Override
    public List<CurrículoemOferta> listarTodos() throws PersistenciaException {
        List <CurrículoemOferta> curriculoList = new ArrayList<CurrículoemOferta>();
        
        CurrículoemOferta curriculo = null;
        
        try{
            Connection connection = new PostgresqlConnection().getConnection();

            String sql = "SELECT * FROM Encargo Didático";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    curriculo = new CurrículoemOferta();
                    
                    curriculo.setIdtPeriodo(new PeríodoLetivoDAO().consultaPorId(resultSet.getInt("idt_Periodo")));
                    curriculo.setRelaçãoCursoDisciplina(new ModuloDAO().consultarPorId(resultSet.getInt("hor_Inicio")));
                    

                    curriculoList.add(curriculo);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curriculoList;
    }
    
}
