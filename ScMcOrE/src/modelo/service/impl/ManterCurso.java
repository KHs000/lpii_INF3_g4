
package modelo.service.impl;

import modelo.dao.ICursoDAO;
import modelo.dao.impl.CursoDAO;
import modelo.domain.Curso;
import modelo.service.IManterCurso;
import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class ManterCurso implements IManterCurso{

    @Override
    public void cadastrar(Curso curso) throws PersistenciaException, NegocioException {
        
        //RN007
        if (curso.getNomCurso() == null || curso.getNomCurso() == "")
            throw new NegocioException("O nome do curso não foi informado.");
        
        ICursoDAO cursoDAO = new CursoDAO();
        Integer cursoId = cursoDAO.inserir(curso);
        curso.setIdCurso(cursoId);
    }

    @Override
    public List<Curso> listarTodos() throws PersistenciaException, NegocioException {
        ICursoDAO cursoDAO = new CursoDAO();
        List<Curso> listCurso = cursoDAO.listarTodos();
        return listCurso;
    }
    
}
