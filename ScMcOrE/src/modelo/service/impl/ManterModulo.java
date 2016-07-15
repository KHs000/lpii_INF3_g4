/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service.impl;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.Modulo;
import modelo.service.IManterModulo;
import modelo.dao.impl.ModuloDAO;

/**
 *
 * @author DASJ
 */
public class ManterModulo implements IManterModulo {

    @Override
    public Integer cadastrar(Modulo modulo) throws PersistenciaException, NegocioException {
        if(modulo.getCurso() == null)
            throw new NegocioException("Precisa haver uma disciplina válida para o módulo.");
        if(modulo.getDisciplina() == null)
            throw new NegocioException("Precisa haver uma disciplina para o módulo.");
        if(modulo.getIdtModulo() == null)
            throw new NegocioException("Precisa haver definição do módulo");
        if(modulo.getIdtSerie() == null)
            throw new NegocioException("Precisa haver definição da série");
        
        Integer resultado = new ModuloDAO().inserir(modulo);
        modulo.getRelaçãoCursoDisciplinaPK().setIdtRelacao(resultado);
        
        return resultado;
        
    }

    @Override
    public void atualizar(Modulo modulo) throws PersistenciaException, NegocioException {
        if(modulo.getRelaçãoCursoDisciplinaPK().getIdtRelacao() == null)
            throw new NegocioException("Precisa existir um módulo para ser atualizado");
        if(modulo.getCurso() == null)
            throw new NegocioException("Precisa haver uma disciplina válida para o módulo.");
        if(modulo.getDisciplina() == null)
            throw new NegocioException("Precisa haver uma disciplina para o módulo.");
        if(modulo.getIdtModulo() == null)
            throw new NegocioException("Precisa haver definição do módulo");
        if(modulo.getIdtSerie() == null)
            throw new NegocioException("Precisa haver definição da série");
        
        new ModuloDAO().atualizar(modulo);
        
    }

    @Override
    public void excluir(Modulo modulo) throws PersistenciaException, NegocioException {
        if (modulo.getRelaçãoCursoDisciplinaPK().getIdtRelacao() == null) 
            throw new NegocioException("É preciso que exista o módulo.");
        new ModuloDAO().excluir(modulo.getRelaçãoCursoDisciplinaPK().getIdtRelacao());
    }

    @Override
    public List<Modulo> listarTodos() throws PersistenciaException, NegocioException {
        return new ModuloDAO().listarTodos();
    }
    
}
