package WEB-INF.classes.br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IDepartamentoDAO;
import br.cefetmg.inf.model.dao.impl.DepartamentoDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;



/**
 *
 * @author Felipe Rabelo
 */
public class ManterDepartamento implements IManterDepartamento {

    public void cadastrar(Departamento departamento) throws PersistenciaException, NegocioException {
        
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Long departamentoId = departamentoDAO.inserir(departamento);
        departamento.setId(departamentoId);
        
    }

    public List<Departamento> listarTodos() throws PersistenciaException, NegocioException {
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> listDepartamento = departamentoDAO.listarTodos();
        return listDepartamento;   
    }
    
}
