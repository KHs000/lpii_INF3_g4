
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.ICursoDAO;
import br.cefetmg.inf.model.dao.impl.CursoDAO;
import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class ManterCurso implements IManterCurso{

    @Override
    public void cadastrar(Curso curso) throws PersistenciaException, NegocioException {
        
        //RN007
        if (curso.getNome() == null)
            throw new NegocioException("O nome do curso não foi informado.");
        
        ICursoDAO cursoDAO = new CursoDAO();
        Long cursoId = cursoDAO.inserir(curso);
        curso.setId(cursoId);
    }

    @Override
    public List<Curso> listarTodos() throws PersistenciaException, NegocioException {
        ICursoDAO cursoDAO = new CursoDAO();
        List<Curso> listCurso = cursoDAO.listarTodos();
        return listCurso;
    }
    
}
