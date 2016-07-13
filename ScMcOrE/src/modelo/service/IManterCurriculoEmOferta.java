/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.CurrículoemOferta;

/**
 *
 * @author helde
 */
public interface IManterCurriculoEmOferta {
    
    public Long cadastrar(CurrículoemOferta curriculo) throws PersistenciaException, NegocioException;
    public List<CurrículoemOferta> listarTodos() throws PersistenciaException, NegocioException;
    
}
