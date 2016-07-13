/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import db.NegocioException;
import db.PersistenciaException;
import java.util.List;
import modelo.domain.PeríodoLetivo;

/**
 *
 * @author Conta Única
 */
public interface IManterPeriodoLetivo {
     public boolean cadastrar(PeríodoLetivo períodoLetivo) throws PersistenciaException, NegocioException;
    public boolean alterar(PeríodoLetivo períodoLetivo) throws PersistenciaException, NegocioException;
    public boolean excluir(PeríodoLetivo períodoLetivo) throws PersistenciaException, NegocioException;
    public List<PeríodoLetivo> pesquisarTodos() throws PersistenciaException;
    public PeríodoLetivo pesquisarPorId(Integer id) throws PersistenciaException, NegocioException;  
}
