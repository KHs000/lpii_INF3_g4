package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlJDBCConnection implements JDBCConnectionFactory {

    /*
    * SERVIDOR FORNECIDO PELA HEROKU INC.
    */

    private final static String dbDriver = "org.postgresql.Driver";
    private final static String remoteServerUrl = "ec2-54-235-95-102.compute-1.amazonaws.com";
    private final static String remoteDbName = "d3ihsse98sk5ba";
    private final static String user = "zsyqgaezidvvww";
    private final static String pass = "_fj0TBQTMWAeDZLzlWzkPRUKlC";
    private final static String connectionUrl =
            "jdbc:postgresql://"+ remoteServerUrl + ":"  +
                    "5432" + "/" + remoteDbName+
                    "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory" +  // Força o uso de SSL
                    "&user=" + user +
                    "&password=" + pass ;
    public PostgresqlJDBCConnection() {}

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        System.out.println(connectionUrl);
        Class.forName(dbDriver);
        return DriverManager.getConnection(connectionUrl);
    }
}