
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.ITurmaDAO;
import br.cefetmg.inf.model.dao.impl.TurmaDAO;
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.model.service.IManterTurma;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class ManterTurma implements IManterTurma{

    @Override
    public void cadastrar(Turma turma) throws PersistenciaException, NegocioException {
        
        //RN009
        if (turma.getVagasLimite() == 0)
            throw new NegocioException("Esta turma já alcançou seu limite de alunos.");
        
        ITurmaDAO turmaDAO = new TurmaDAO();
        Long turmaId = turmaDAO.inserir(turma);
        turma.setId(turmaId);
    }

    @Override
    public List<Turma> listarTodos() throws PersistenciaException, NegocioException {
        ITurmaDAO turmaDAO = new TurmaDAO();
        List<Turma> listTurma = turmaDAO.listarTodos();
        return listTurma;
    }
    
}
