/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.Modulo;

/**
 *
 * @author DASJ
 */
public interface IManterModulo {
    
    public Integer cadastrar(Modulo modulo) throws PersistenciaException, NegocioException;
    public void atualizar(Modulo modulo) throws PersistenciaException, NegocioException;
    public void excluir(Modulo modulo) throws PersistenciaException, NegocioException;
    public List<Modulo> listarTodos() throws PersistenciaException, NegocioException;
    
}
