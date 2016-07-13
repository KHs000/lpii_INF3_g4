package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;



/**
 *
 * @author Felipe Rabelo
 */
public class ManterDisciplina implements IManterDisciplina {

    public void cadastrar(Disciplina disciplina) throws PersistenciaException, NegocioException {
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        Long disciplinaId = disciplinaDAO.inserir(disciplina);
        disciplina.setId(disciplinaId);
    }

    public List<Disciplina> listarTodos() throws PersistenciaException, NegocioException {
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        List<Disciplina> listDisciplina = disciplinaDAO.listarTodos();
        return listDisciplina;
    }
    
}
