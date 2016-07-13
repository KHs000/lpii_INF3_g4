/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service;

import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.Professor;

/**
 *
 * @author Henrique
 */
public interface IManterProfessor {
    
    public void cadastrar(Professor professor) throws PersistenciaException, NegocioException;
    public List<Professor> listarTodos() throws PersistenciaException, NegocioException;
    
}
