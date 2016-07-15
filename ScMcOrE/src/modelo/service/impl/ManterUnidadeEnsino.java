/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service.impl;

import db.PersistenciaException;
import java.util.List;
import modelo.dao.impl.UnidadedeEnsinoDAO;
import modelo.domain.UnidadedeEnsino;
import modelo.service.IManterUnidadeEnsino;
import db.NegocioException;

/**
 *
 * @author Conta Única
 */
public class ManterUnidadeEnsino implements IManterUnidadeEnsino{

    @Override
    public boolean cadastrar(UnidadedeEnsino unidadedeEnsino) throws PersistenciaException, NegocioException {
        if(unidadedeEnsino.getNomUnidadeEnsino().isEmpty())
            throw new NegocioException("O nome da Unidade de Ensino tem que ser informado");
        
        boolean resultado = new UnidadedeEnsinoDAO().insere(unidadedeEnsino);
        return resultado;
    }

    @Override
    public boolean alterar(UnidadedeEnsino unidadedeEnsino) throws PersistenciaException, NegocioException {
        if(unidadedeEnsino.getNomUnidadeEnsino().isEmpty())
            throw new NegocioException("O nome da Unidade de Ensino tem que ser informado");
        
        boolean resultado = new UnidadedeEnsinoDAO().atualiza(unidadedeEnsino);
        return resultado;
    }

    @Override
    public boolean excluir(UnidadedeEnsino unidadedeEnsino) throws PersistenciaException, NegocioException {
        if(unidadedeEnsino.getIdUnidade() == null)
            throw new NegocioException("O Id da Unidade precisa ser informado");

        boolean resultado = new UnidadedeEnsinoDAO().delete(unidadedeEnsino.getIdUnidade());
        return resultado;
    }

    @Override
    public List<UnidadedeEnsino> pesquisarTodos() throws PersistenciaException {
        List<UnidadedeEnsino> retorno = new UnidadedeEnsinoDAO().listaTodas();
        return retorno;
    }

    @Override
    public UnidadedeEnsino pesquisarPorId(Integer id) throws PersistenciaException, NegocioException {
        if(id == null)
            throw new NegocioException("O Id da Unidade precisa ser informado");
        UnidadedeEnsino retorno  = new UnidadedeEnsinoDAO().consultaPorId(id);
        return retorno;
    }
    
}
