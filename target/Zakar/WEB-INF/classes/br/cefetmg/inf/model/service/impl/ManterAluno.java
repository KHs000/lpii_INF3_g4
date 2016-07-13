package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IAlunoDAO;
import br.cefetmg.inf.model.dao.impl.AlunoDAO;
import br.cefetmg.inf.model.domain.Aluno;
import br.cefetmg.inf.model.service.IManterAluno;
import br.cefetmg.inf.util.CPF;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterAluno implements IManterAluno {

    @Override
    public void cadastrar(Aluno aluno) throws PersistenciaException, NegocioException {

        //RN001
        if(aluno == null)
            throw new NegocioException("Dados do aluno não foram informados.");
        
        //RN001
        if(aluno.getNome() == null)
            throw new NegocioException("Nome do aluno deve ser informado.");

        //RN002
        if(aluno.getNome().split(" ").length < 2)
            throw new NegocioException("Nome do aluno deve ser informado.");
            
        //RN003
        if(!CPF.ehValido(aluno.getCpf()))
            throw new NegocioException("RN003: Número do CPF não é válido.");
        
        //RN004
        if((aluno.getEndereco() == null) || aluno.getEndereco().isEmpty())
            throw new NegocioException("Endereço do aluno deve ser informado.");
        
        IAlunoDAO alunoDAO = new AlunoDAO();
        Long alunoId = alunoDAO.inserir(aluno);
        aluno.setId(alunoId);
    }

    
    @Override
    public List<Aluno> listarTodos() throws PersistenciaException, NegocioException {
        IAlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> listAluno = alunoDAO.listarTodos();
        return listAluno;
    }    
}
