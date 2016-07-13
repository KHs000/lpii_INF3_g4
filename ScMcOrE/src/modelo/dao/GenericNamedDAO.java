
package modelo.dao;

import db.exception.PersistenciaException;

public interface GenericNamedDAO<Entidade> extends GenericDAO<Entidade> {
    
    Entidade consultarPorNome(String nome) throws PersistenciaException;
}
