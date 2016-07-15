/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service.impl;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.dao.impl.AlocaçãoDAO;
import modelo.domain.Alocação;
import modelo.service.IManterAlocação;

/**
 *
 * @author Cliente
 */
public class ManterAlocação implements IManterAlocação{

    @Override
    public Integer cadastrar(Alocação alocação) throws PersistenciaException, NegocioException {
        java.util.Date utilDate = new java.util.Date();
        if(alocação.getDatAlocacao()== null)
            throw new NegocioException("A data da alocação precisa ser informada");
        if(alocação.getDatAlocacao().before(new java.sql.Date(utilDate.getTime())))
            throw new NegocioException("A data de alocação deve ser válida");
        if(alocação.getCpfProfessor() == null)
            throw new NegocioException("O CPF do professor locatário deve ser informado");
        if(alocação.getIdAmbiente() == null)
            throw new NegocioException("O Id do Ambiente deve ser informado");
        
        Integer resultado = new AlocaçãoDAO().inserir(alocação);
        alocação.setIdAlocacao(resultado);
        return resultado;
    }

    @Override
    public void atualizar(Alocação alocação) throws PersistenciaException, NegocioException {
        java.util.Date utilDate = new java.util.Date();
        if(alocação.getDatAlocacao()== null)
            throw new NegocioException("A data da alocação precisa ser informada");
        if(alocação.getDatAlocacao().before(new java.sql.Date(utilDate.getTime())))
            throw new NegocioException("A data de alocação deve ser válida");
        if(alocação.getCpfProfessor() == null)
            throw new NegocioException("O CPF do professor locatário deve ser informado");
        if(alocação.getIdAmbiente() == null)
            throw new NegocioException("O Id do Ambiente deve ser informado");
        
        new AlocaçãoDAO().atualizar(alocação);
    }

    @Override
    public void excluir(Alocação alocação) throws PersistenciaException, NegocioException {
        if (alocação.getIdAlocacao() == null) 
            throw new NegocioException("É preciso que exista a alocação a ser excluída.");
        new AlocaçãoDAO().excluir(alocação.getIdAlocacao());
    }

    @Override
    public List<Alocação> listarTodos() throws PersistenciaException, NegocioException {
        return new AlocaçãoDAO().listarTodos();
    }
    
}
