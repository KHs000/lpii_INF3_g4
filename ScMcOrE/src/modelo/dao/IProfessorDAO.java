/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;


import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.Professor;

/**
 *
 * @author Henrique
 */
public interface IProfessorDAO {
    
    void inserir(Professor obj) throws PersistenciaException;
    void atualizar(Professor obj) throws PersistenciaException;
    void excluir(String cpf) throws PersistenciaException;
    Professor consultarPorCpf(String cpf) throws PersistenciaException;
    List<Professor> listarTodos() throws PersistenciaException;
    Professor consultarPorNome(String nome) throws PersistenciaException;
    
}
