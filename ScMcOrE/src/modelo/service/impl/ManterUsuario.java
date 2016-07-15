
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.impl.UsuarioDAO;
import modelo.domain.Usuario;
import br.cefetmg.inf.model.service.IManterUsuario;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class ManterUsuario implements IManterUsuario{

    @Override
    public void cadastrar(Usuario usuario) throws PersistenciaException, NegocioException {
        
        if (usuario.getCpfUsuario()== "" || usuario.getCpfUsuario()== null || usuario.getCpfUsuario().length()>11)
            throw new NegocioException("CPF inválido");
        if (usuario.getCpfUsuario()== "" || usuario.getCpfUsuario()== null || usuario.getCpfUsuario().length()>11)
            throw new NegocioException("CPF inválido");
        if (usuario.getCpfUsuario()== "" || usuario.getCpfUsuario()== null || usuario.getCpfUsuario().length()>11)
            throw new NegocioException("CPF inválido");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String usuarioCpf =  usuarioDAO.Inserir(usuario);
        usuario.setCpfUsuario(usuarioCpf);
    }

    @Override
    public List<Usuario> listarTodos() throws PersistenciaException, NegocioException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> listUsuario = usuarioDAO.listarTodos();
        return listUsuario;
    }
    
}
