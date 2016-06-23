
package br.cefetmg.inf.model.service;

import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public interface IManterCurso {
    
    public void cadastrar(Curso curso) throws PersistenciaException, NegocioException;
    public List<Curso> listarTodos() throws PersistenciaException, NegocioException;
    
}
