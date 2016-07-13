package WEB-INF.classes.br.cefetmg.inf.model.service;

import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;



/**
 *
 * @author Felipe Rabelo
 */
public interface IManterDisciplina {
    
    public void cadastrar(Disciplina disciplina) throws PersistenciaException, NegocioException;
    public List<Disciplina> listarTodos() throws PersistenciaException, NegocioException;
    
}
