/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service;

import br.cefetmg.inf.model.domain.EncargoDidatico;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author DASJ
 */
public interface IManterEncargoDidatico {
    
    public void cadastrar(EncargoDidatico encargo) throws PersistenciaException, NegocioException;
    public List<EncargoDidatico> listarTodos() throws PersistenciaException, NegocioException;
    
}
