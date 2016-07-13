/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service.impl;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.EncargoDidático;
import modelo.service.IManterEncargoDidatico;

/**
 *
 * @author helde
 */
public class ManterEncargoDidatico implements IManterEncargoDidatico {

    @Override
    public void cadastrar(EncargoDidático encargo) throws PersistenciaException, NegocioException {
        if (encargo.getDiaSemana()==7) {
            throw new NegocioException("As unidades são fechadas aos domingos.");
        }

    }

    @Override
    public List<EncargoDidático> listarTodos() throws PersistenciaException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
