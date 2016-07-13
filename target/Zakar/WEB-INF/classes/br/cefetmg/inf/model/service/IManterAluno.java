package br.cefetmg.inf.model.service;

import br.cefetmg.inf.model.domain.Aluno;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public interface IManterAluno {

    public void cadastrar(Aluno aluno) throws PersistenciaException, NegocioException;
    public List<Aluno> listarTodos() throws PersistenciaException, NegocioException;

}
