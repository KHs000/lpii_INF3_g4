
package br.cefetmg.inf.model.service;

import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public interface IManterTurma {
    
    public void cadastrar(Turma turma) throws PersistenciaException, NegocioException;
    public List<Turma> listarTodos() throws PersistenciaException, NegocioException;
    
}
