package modelo.service;

import modelo.domain.Departamento;
import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;



/**
 *
 * @author Felipe Rabelo
 */
public interface IManterDepartamento {
    
    public void cadastrar(Departamento departamento) throws PersistenciaException, NegocioException;
    public List<Departamento> listarTodos() throws PersistenciaException, NegocioException;
    
}
