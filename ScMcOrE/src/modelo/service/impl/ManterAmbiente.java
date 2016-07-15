/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service.impl;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.dao.impl.AmbienteDAO;
import modelo.domain.AmbientesdeEnsino;
import modelo.service.IManterAmbiente;

/**
 *
 * @author Cliente
 */
public class ManterAmbiente implements IManterAmbiente {

    @Override
    public Integer cadastrar(AmbientesdeEnsino ambiente) throws PersistenciaException, NegocioException {
        java.util.Date utilDate = new java.util.Date();
        if(ambiente.getNomAmbiente() == 0)
            throw new NegocioException("O nome do ambiente precisa ser informado");
        if(ambiente.getDesAmbiente() == null)
            throw new NegocioException("A descrição do ambiente deve ser preenchida");
        if(ambiente.getIdUnidade() == null)
            throw new NegocioException("O id da unidade precisa ser informado");
        
        Integer resultado = new AmbienteDAO().inserir(ambiente);
        ambiente.setIdAmbiente(resultado);
        return resultado;
    }

    @Override
    public void atualizar(AmbientesdeEnsino ambiente) throws PersistenciaException, NegocioException {
        java.util.Date utilDate = new java.util.Date();
        if(ambiente.getNomAmbiente() == 0)
            throw new NegocioException("O nome do ambiente precisa ser informado");
        if(ambiente.getDesAmbiente() == null)
            throw new NegocioException("A descrição do ambiente deve ser preenchida");
        if(ambiente.getIdUnidade() == null)
            throw new NegocioException("O id da unidade precisa ser informado");
        
        new AmbienteDAO().atualizar(ambiente);
    }

    @Override
    public void excluir(AmbientesdeEnsino ambiente) throws PersistenciaException, NegocioException {
        if (ambiente.getIdAmbiente()== null) 
            throw new NegocioException("É preciso que exista o ambiente a ser excluido.");
        new AmbienteDAO().excluir(ambiente.getIdAmbiente());
    }

    @Override
    public List<AmbientesdeEnsino> listarTodos() throws PersistenciaException, NegocioException {
        return new AmbienteDAO().listarTodos();
    }
    
}
