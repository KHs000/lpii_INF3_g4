
package modelo.service;

import modelo.domain.Curso;
import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public interface IManterCurso {
    
    public void cadastrar(Curso curso) throws PersistenciaException, NegocioException;
    public List<Curso> listarTodos() throws PersistenciaException, NegocioException;
    
}
