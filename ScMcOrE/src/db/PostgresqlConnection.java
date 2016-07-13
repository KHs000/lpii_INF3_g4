package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresqlConnection implements ConnectionFactory {
    
    private final static String ServerUrl = "ec2-54-243-203-143.compute-1.amazonaws.com";
    private final static String dbDriver = "org.postgresql.Driver";
    private final static String DbName = "d2bq4n4gih8m47";
    private final static String user = "mlbewuwxipqdxe";
    private final static String pass = "AFkHnl5GAInDV18d1xVVEQzfuL";
    private final static String connectionUrl =
            "jdbc:postgresql://"+ ServerUrl + ":"  +
                    "5432" + "/" + DbName +
                    "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory" +  // Forca o uso de SSL
                    "&user=" + user +
                    "&password=" + pass ;
    
    public PostgresqlConnection() {
    
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        
        return DriverManager.getConnection(connectionUrl);
    }
    
}
