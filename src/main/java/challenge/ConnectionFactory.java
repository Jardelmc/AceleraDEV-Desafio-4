package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection createConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite::resource:database.sqlite");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
