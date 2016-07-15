/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.AmbientesdeEnsino;
import modelo.domain.CurrículoemOferta;

/**
 *
 * @author Cliente
 */
public interface IManterAmbiente {
    public Integer cadastrar(AmbientesdeEnsino ambiente) throws PersistenciaException, NegocioException;
    public void atualizar(AmbientesdeEnsino ambiente) throws PersistenciaException, NegocioException;
    public void excluir(AmbientesdeEnsino ambiente) throws PersistenciaException, NegocioException;
    public List<AmbientesdeEnsino> listarTodos() throws PersistenciaException, NegocioException;
}
