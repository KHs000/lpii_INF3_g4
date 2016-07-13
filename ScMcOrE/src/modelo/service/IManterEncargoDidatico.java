/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.EncargoDidático;

/**
 *
 * @author helde
 */
public interface IManterEncargoDidatico {
    
    public void cadastrar(EncargoDidático encargo) throws PersistenciaException, NegocioException;
    public List<EncargoDidático> listarTodos() throws PersistenciaException, NegocioException;
    
}
