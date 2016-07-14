/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service.impl;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.dao.impl.CurriculoEmOfertaDAO;
import modelo.domain.CurrículoemOferta;
import modelo.service.IManterCurriculoEmOferta;

/**
 *
 * @author helde
 */
public class ManterCurriculoEmOferta implements IManterCurriculoEmOferta {

    @Override
    public Integer cadastrar(CurrículoemOferta curriculo) throws PersistenciaException, NegocioException {
        java.util.Date utilDate = new java.util.Date();
        if(curriculo.getIdtPeriodo()== null)
            throw new NegocioException("O período do currículo em oferta precisa ser informado");
        if(curriculo.getIdtPeriodo().getDatFim().before(new java.sql.Date(utilDate.getTime())))
            throw new NegocioException("O período não pode ter acabado.");
        if(curriculo.getRelaçãoCursoDisciplina() == null)
            throw new NegocioException("O módulo ofertado precisa ser informado");
        
        Integer resultado = new CurriculoEmOfertaDAO().inserir(curriculo);
        curriculo.setIdCurriculoOferta(resultado);
        return resultado;
        
    }

    @Override
    public void atualizar(CurrículoemOferta curriculo) throws PersistenciaException, NegocioException {
        java.util.Date utilDate = new java.util.Date();
        if(curriculo.getIdtPeriodo()== null)
            throw new NegocioException("O período do currículo em oferta precisa ser informado");
        if(curriculo.getIdtPeriodo().getDatFim().before(new java.sql.Date(utilDate.getTime())))
            throw new NegocioException("O período não pode ter acabado.");
        if(curriculo.getRelaçãoCursoDisciplina() == null)
            throw new NegocioException("O módulo ofertado precisa ser informado");
        
        new CurriculoEmOfertaDAO().atualizar(curriculo);

    }

    @Override
    public void excluir(CurrículoemOferta curriculo) throws PersistenciaException, NegocioException {
        
        if (curriculo.getIdCurriculoOferta() == null) 
            throw new NegocioException("É preciso que exista o currículo ofertado.");
        new CurriculoEmOfertaDAO().excluir(curriculo.getIdCurriculoOferta());
        
    }

    @Override
    public List<CurrículoemOferta> listarTodos() throws PersistenciaException, NegocioException {
        return new CurriculoEmOfertaDAO().listarTodos();
    }
    
}
