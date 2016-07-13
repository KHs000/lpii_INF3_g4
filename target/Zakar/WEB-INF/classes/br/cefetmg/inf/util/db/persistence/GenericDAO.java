package br.cefetmg.inf.util.db.persistence;

import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public interface GenericDAO<Entidade> {

    Long inserir(Entidade obj) throws PersistenciaException;
    void atualizar(Entidade obj) throws PersistenciaException;
    void excluir(Long id) throws PersistenciaException;
    Entidade consultarPorId(Long id) throws PersistenciaException;
    List<Entidade> listarTodos() throws PersistenciaException;

}
