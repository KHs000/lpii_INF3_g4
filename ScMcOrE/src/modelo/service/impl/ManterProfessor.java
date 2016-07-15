
package modelo.service.impl;


import modelo.dao.impl.ProfessorDAO;
import modelo.service.IManterProfessor;
import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.dao.IProfessorDAO;
import modelo.domain.Professor;

/**
 *
 * @author Felipe Rabelo
 */
public class ManterProfessor implements IManterProfessor{

    @Override
    public void cadastrar(Professor professor) throws PersistenciaException, NegocioException {
        
        //RN009
        if ( professor.getCpfProfessor()== null || professor.getCpfProfessor()== ""  || professor.getCpfProfessor().length()>12)
            throw new NegocioException("CPF inválido");
        if ( professor.getNomProfessor()== null || professor.getNomProfessor()== ""  )
            throw new NegocioException("Nome inválidolido");
        if ( professor.getLogProfessor()== null || professor.getLogProfessor()== "" )
            throw new NegocioException("Log-in inválido");
        if ( professor.getPwdProfessor()== null || professor.getPwdProfessor()== "" || professor.getPwdProfessor().length()<8 )
            throw new NegocioException("Senha inválida");
        ProfessorDAO professorDAO = new ProfessorDAO();
        
    }

    @Override
    public List<Professor> listarTodos() throws PersistenciaException, NegocioException {
        IProfessorDAO turmaDAO = new ProfessorDAO();
        List<Professor> listProfessor = turmaDAO.listarTodos();
        return listProfessor;
    }
    
}
