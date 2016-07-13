
package br.cefetmg.inf.util.db.persistence;

import br.cefetmg.inf.util.db.exception.PersistenciaException;

public interface GenericNamedDAO<Entidade> extends GenericDAO<Entidade> {
    
    Entidade consultarPorNome(String nome) throws PersistenciaException;
}
