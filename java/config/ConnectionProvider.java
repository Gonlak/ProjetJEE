package config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
    private static DataSource dataSource;

    static {
        Context context = null;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jbdc/pool_cnx");
        } catch (NamingException e) {
            throw new RuntimeException("Impossible d'accéder à la base de données");
        }
    }

    // retourne une connexion issue du pool de connexion
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
