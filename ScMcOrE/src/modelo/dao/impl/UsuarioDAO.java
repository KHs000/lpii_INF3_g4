
package br.cefetmg.inf.model.dao.impl;

import WEBINF.classes.br.cefetmg.inf.model.dao.IUsuarioDAO;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.domain.Usuario;

/**
 *
 * @author Felipe Rabelo
 */
public class UsuarioDAO implements IUsuarioDAO {

    public Usuario consultarPorNome(String login) throws PersistenciaException {
        
        Usuario usuario = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuário WHERE log_Usuario = " + login;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setCpfUsuario(resultSet.getString("cpf_Usuario"));
                    usuario.setLogUsuario(resultSet.getString("log_Usuario"));
                    usuario.setPwdUsuario(resultSet.getString("pwd_Usuario"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return usuario;
    }

    public String Inserir(Usuario usuario) throws PersistenciaException {
        
        String CPF = null;

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Usuário (cpf_Usuario, log_Usuario, pwd_Usuario) " + 
                    "VALUES(?,?,?) RETURNING cpf_Usuario";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, usuario.getCpfUsuario());
            statement.setString(2, usuario.getLogUsuario());
            statement.setString(3, usuario.getPwdUsuario());
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                CPF = (resultSet.getString("cpf_Usuario"));
                usuario.setCpfUsuario(CPF);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return CPF;
    }

    public void atualizar(Usuario usuario) throws PersistenciaException {
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Usuário " +
                            " SET log_Usuario = ?, " +
                            "     pwd_Usuario = ?," +
                            " WHERE cpf_Usuario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, usuario.getLogUsuario());
            statement.setString(2, usuario.getPwdUsuario());
            statement.setString(3, usuario.getCpfUsuario());

            statement.execute();

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    public void excluir(Long cpf_Usuario) throws PersistenciaException {
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM usuario WHERE cpf_Usuario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, cpf_Usuario);

            statement.execute();
            connection.close();
        }catch(Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
    }

    public Usuario consultarPorId(Long cpf_Usuario) throws PersistenciaException {
        Usuario usuario = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuário WHERE cpf_Usuario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cpf_Usuario);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setCpfUsuario(resultSet.getString("cpf_Usuario"));
                    usuario.setLogUsuario(resultSet.getString("log_Usuario"));
                    usuario.setPwdUsuario(resultSet.getString("pwd_Usuario"));
            }
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return usuario;
    }

    public List<Usuario> listarTodos() throws PersistenciaException {
        
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        
        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuário";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Usuario usuario = new Usuario();
                    usuario.setCpfUsuario(resultSet.getString("cpf_Usuario"));
                    usuario.setLogUsuario(resultSet.getString("log_Usuario"));
                    usuario.setPwdUsuario(resultSet.getString("pwd_Usuario"));

                    usuarioList.add(usuario);
            }
            connection.close();
        }catch (Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return usuarioList;
    }

    public Long inserir(Usuario obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
