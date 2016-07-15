/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service.impl;

import db.exception.PersistenciaException;
import java.util.List;
import modelo.dao.impl.PeríodoLetivoDAO;
import modelo.domain.PeríodoLetivo;
import modelo.service.IManterPeriodoLetivo;
import db.exception.NegocioException;

/**
 *
 * @author Conta Única
 */
public class ManterPeriodoLetivo implements IManterPeriodoLetivo{

    @Override
    public boolean cadastrar(PeríodoLetivo períodoLetivo) throws PersistenciaException, NegocioException {
        if(períodoLetivo.getDatInicio() == null)
            throw new NegocioException("A data de início precisa ser informada");
        if(períodoLetivo.getDatFim() == null)
            throw new NegocioException("A data de término precisa ser informada");
        Character Idt_Regime = (Character.toLowerCase(períodoLetivo.getIdtRegime()));
        if( Idt_Regime.compareTo('A') != 0  && Idt_Regime.compareTo('S') != 0 && Idt_Regime.compareTo('M') != 0 )
            throw new NegocioException("O regime deve ser do tipo \"A\"(Anual) \"S\"(Semestral) \"M\"(Mensal) ");
        
        boolean resultado = new PeríodoLetivoDAO().insere(períodoLetivo);
        return resultado;
    }

    @Override
    public boolean alterar(PeríodoLetivo períodoLetivo) throws PersistenciaException, NegocioException {
         if(períodoLetivo.getIdtPeriodo() == null)
            throw new NegocioException("O id do período precisa ser informado");
        if(períodoLetivo.getDatInicio() == null)
            throw new NegocioException("A data de início precisa ser informada");
        if(períodoLetivo.getDatFim() == null)
            throw new NegocioException("A data de término precisa ser informada");
        Character Idt_Regime = (Character.toLowerCase(períodoLetivo.getIdtRegime()));
        if( Idt_Regime.compareTo('A') != 0  && Idt_Regime.compareTo('S') != 0 && Idt_Regime.compareTo('M') != 0 )
            throw new NegocioException("O regime deve ser do tipo \"A\"(Anual) \"S\"(Semestral) \"M\"(Mensal) ");
        
        
        boolean resultado = new PeríodoLetivoDAO().atualiza(períodoLetivo);
        return resultado;
    }

    @Override
    public boolean excluir(PeríodoLetivo períodoLetivo) throws PersistenciaException, NegocioException {
        if(períodoLetivo.getIdtPeriodo() == null)
            throw new NegocioException("O id do período precisa ser informado");

        boolean resultado = new PeríodoLetivoDAO().delete(períodoLetivo.getIdtPeriodo());
        return resultado;
    }

    @Override
    public List<PeríodoLetivo> pesquisarTodos() throws PersistenciaException {
        List<PeríodoLetivo> retorno = new PeríodoLetivoDAO().listaTodas();
        return retorno;
    }

    @Override
    public PeríodoLetivo pesquisarPorId(Integer id) throws PersistenciaException, NegocioException {
        if(id == null)
            throw new NegocioException("O Id do período precisa ser informado");
        PeríodoLetivo retorno  = new PeríodoLetivoDAO().consultaPorId(id);
        return retorno;
    }
    
}
