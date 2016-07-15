package modelo.service;

import modelo.domain.Disciplina;
import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;



/**
 *
 * @author Felipe Rabelo
 */
public interface IManterDisciplina {
    
    public void cadastrar(Disciplina disciplina) throws PersistenciaException, NegocioException;
    public List<Disciplina> listarTodos() throws PersistenciaException, NegocioException;
    
}
