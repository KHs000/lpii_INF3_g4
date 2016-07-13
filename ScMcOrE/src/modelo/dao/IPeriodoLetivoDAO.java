/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import db.PersistenciaException;
import java.util.List;
import modelo.domain.PeríodoLetivo;

/**
 *
 * @author Conta Única
 */
public interface IPeriodoLetivoDAO {
    public abstract boolean insere(PeríodoLetivo u) throws PersistenciaException;
    public abstract PeríodoLetivo consultaPorId(Integer id) throws PersistenciaException;
    public abstract boolean delete(Integer id) throws PersistenciaException;
    public abstract boolean atualiza(PeríodoLetivo u) throws PersistenciaException;
    public abstract List<PeríodoLetivo> listaTodas() throws PersistenciaException;
}
