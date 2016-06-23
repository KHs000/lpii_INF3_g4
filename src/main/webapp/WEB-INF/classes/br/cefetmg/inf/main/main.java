
package br.cefetmg.inf.main;
import br.cefetmg.inf.util.db.PostgresqlJDBCConnection;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;
/**
 *
 * @author Felipe Rabelo
 */
public class main {
    public static void main (String [] args) {
       try{
        new PostgresqlJDBCConnection().getConnection();
       } catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
       }
    }
}
