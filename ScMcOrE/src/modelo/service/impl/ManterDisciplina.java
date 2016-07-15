package modelo.service.impl;

import modelo.domain.Disciplina;
import modelo.service.IManterDisciplina;
import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.dao.IDisciplinaDAO;
import modelo.dao.impl.DisciplinaDAO;



/**
 *
 * @author Felipe Rabelo
 */
public class ManterDisciplina implements IManterDisciplina {

    public void cadastrar(Disciplina disciplina) throws PersistenciaException, NegocioException {
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        Integer disciplinaId = disciplinaDAO.inserir(disciplina);
        disciplina.setIdDisciplina(disciplinaId);
    }

    public List<Disciplina> listarTodos() throws PersistenciaException, NegocioException {
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        List<Disciplina> listDisciplina = disciplinaDAO.listarTodos();
        return listDisciplina;
    }
    
}
