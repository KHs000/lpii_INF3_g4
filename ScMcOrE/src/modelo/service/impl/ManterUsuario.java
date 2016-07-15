
package modelo.service.impl;

import modelo.dao.impl.UsuarioDAO;
import modelo.domain.Usuario;
import modelo.service.IManterUsuario;
import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class ManterUsuario implements IManterUsuario{

    @Override
    public void cadastrar(Usuario usuario) throws PersistenciaException, NegocioException {
        
        if (usuario.getLogUsuario() == null || usuario.getLogUsuario() == "" || usuario.getLogUsuario().length()>12)
            throw new NegocioException("Login de usuário inválido.");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Integer idUsuario =  usuarioDAO.inserir(usuario);
        usuario.setIdUsuario(idUsuario);
    }

    @Override
    public List<Usuario> listarTodos() throws PersistenciaException, NegocioException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> listUsuario = usuarioDAO.listarTodos();
        return listUsuario;
    }
    
}
