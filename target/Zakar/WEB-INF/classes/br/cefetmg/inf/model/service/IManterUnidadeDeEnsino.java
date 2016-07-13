
package br.cefetmg.inf.model.service;

import br.cefetmg.inf.model.domain.UnidadeDeEnsino;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public interface IManterUnidadeDeEnsino {
    
    public void cadastrar(UnidadeDeEnsino unidadeDeEnsino) throws PersistenciaException, NegocioException;
    public List<UnidadeDeEnsino> listarTodos() throws PersistenciaException, NegocioException;
    
}
