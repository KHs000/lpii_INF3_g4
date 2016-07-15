/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.UnidadedeEnsino;

public interface IUnidadedeEnsinoDAO {
    public abstract boolean insere(UnidadedeEnsino u) throws PersistenciaException;
    public abstract UnidadedeEnsino consultaPorId(Integer id) throws PersistenciaException;
    public abstract boolean delete(Integer id) throws PersistenciaException;
    public abstract boolean atualiza(UnidadedeEnsino u) throws PersistenciaException;
    public abstract List<UnidadedeEnsino> listaTodas() throws PersistenciaException;
}
