package modelo.service.impl;

import modelo.dao.IDepartamentoDAO;
import modelo.dao.impl.DepartamentoDAO;
import modelo.domain.Departamento;
import modelo.service.IManterDepartamento;
import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;



/**
 *
 * @author Felipe Rabelo
 */
public class ManterDepartamento implements IManterDepartamento {

    public void cadastrar(Departamento departamento) throws PersistenciaException, NegocioException {
        
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Integer departamentoId = departamentoDAO.inserir(departamento);
        departamento.setIdDepartamento(departamentoId);
        
    }

    public List<Departamento> listarTodos() throws PersistenciaException, NegocioException {
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> listDepartamento = departamentoDAO.listarTodos();
        return listDepartamento;   
    }
    
}
