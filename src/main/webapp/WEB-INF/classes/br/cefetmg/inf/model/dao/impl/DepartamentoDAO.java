
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDepartamentoDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class DepartamentoDAO implements IDepartamentoDAO{

    @Override
    public Departamento consultarPorNome(String nome) throws PersistenciaException {
        
        Departamento departamento = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String sql = "SELECT * FROM Departamento WHERE nome = " + nome;
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                departamento = new Departamento();
                departamento.setId(resultSet.getLong("id"));
                departamento.setNome(resultSet.getString("nome"));
                departamento.setSigla(resultSet.getString("sigla"));
                departamento.setTelefone(resultSet.getString("telefone"));
                departamento.setEndereco(resultSet.getString("endereco"));
                departamento.setEmail(resultSet.getString("email"));
                departamento.setUrl(resultSet.getString("url"));
                //departamento.setUnidadeDeEnsino(resultSet.getObject("Und_Ensino")); Und_Ensino DEVE SER CONVERTIDO PARA OBJECT
            }
            connection.close();
        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return departamento;
    }

    @Override
    public Long inserir(Departamento obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Departamento obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Departamento consultarPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departamento> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
