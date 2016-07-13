package WEB-INF.classes.br.cefetmg.inf.model.service;

import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;



/**
 *
 * @author Felipe Rabelo
 */
public interface IManterDepartamento {
    
    public void cadastrar(Departamento departamento) throws PersistenciaException, NegocioException;
    public List<Departamento> listarTodos() throws PersistenciaException, NegocioException;
    
}
