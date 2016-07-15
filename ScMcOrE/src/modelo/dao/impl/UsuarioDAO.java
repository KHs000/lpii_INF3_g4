
package modelo.dao.impl;



import db.ConnectionManager;
import db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.IUsuarioDAO;
import modelo.domain.Usuario;

/**
 *
 * @author Felipe Rabelo
 */
public class UsuarioDAO implements IUsuarioDAO {

    public Usuario consultarPorNome(String login) throws PersistenciaException {
        
        Usuario usuario = null;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuário WHERE log_Usuario = ? " + login;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(resultSet.getInt("id_Usuario"));
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

    public Integer inserir(Usuario usuario) throws PersistenciaException {
        
        Integer id = null;

        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Usuário (log_Usuario, pwd_Usuario) " + 
                    "VALUES(?,?) RETURNING id_Usuario";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, usuario.getLogUsuario());
            statement.setString(2, usuario.getPwdUsuario());
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = (resultSet.getInt("id_Usuario"));
                usuario.setIdUsuario(id);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    public void atualizar(Usuario usuario) throws PersistenciaException {
        
        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Usuário " +
                            " SET log_Usuario = ?, " +
                            "     pwd_Usuario = ?," +
                            " WHERE id_Usuario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, usuario.getLogUsuario());
            statement.setString(2, usuario.getPwdUsuario());
            statement.setInt(3, usuario.getIdUsuario());

            statement.execute();

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    public void excluir(Integer id_Usuario) throws PersistenciaException {
        
        try{
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Usuário WHERE id_Usuario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id_Usuario);

            statement.execute();
            connection.close();
        }catch(Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
    }

    public Usuario consultarPorId(Integer id) throws PersistenciaException {
        Usuario usuario = null;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuário WHERE id_Usuario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    usuario = new Usuario();
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
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuário";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(resultSet.getInt("id_Usuario"));
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
    
}
