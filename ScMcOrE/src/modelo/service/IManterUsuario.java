
package modelo.service;


import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.domain.Usuario;

/**
 *
 * @author Felipe Rabelo
 */
public interface IManterUsuario {
    
    public void cadastrar(Usuario usuario) throws PersistenciaException, NegocioException;
    public List<Usuario> listarTodos() throws PersistenciaException, NegocioException;
    
}
