/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.UnidadedeEnsino;

/**
 *
 * @author Conta Única
 */
public interface IManterUnidadeEnsino {
    public boolean cadastrar(UnidadedeEnsino unidadedeEnsino) throws PersistenciaException, NegocioException;
    public boolean alterar(UnidadedeEnsino unidadedeEnsino) throws PersistenciaException, NegocioException;
    public boolean excluir(UnidadedeEnsino unidadedeEnsino) throws PersistenciaException, NegocioException;
    public List<UnidadedeEnsino> pesquisarTodos() throws PersistenciaException;
    public UnidadedeEnsino pesquisarPorId(Integer id) throws PersistenciaException, NegocioException;  
}
