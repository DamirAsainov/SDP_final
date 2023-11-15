package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Assuming you have a database named "store" and user credentials
            String url = "jdbc:mysql://localhost:3306/store";
            String username = "your_username";
            String password = "your_password";

            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
