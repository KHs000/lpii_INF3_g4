/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.Alocação;

/**
 *
 * @author Cliente
 */
public interface IManterAlocação {
    public Integer cadastrar(Alocação curriculo) throws PersistenciaException, NegocioException;
    public void atualizar(Alocação curriculo) throws PersistenciaException, NegocioException;
    public void excluir(Alocação curriculo) throws PersistenciaException, NegocioException;
    public List<Alocação> listarTodos() throws PersistenciaException, NegocioException;
}
