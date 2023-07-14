package Question2.data.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private Connection connection;

    public void connect() {
        try {
            // Provide the JDBC driver class name
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set up the connection URL for the MariaDB database
            String url = "jdbc:mysql://localhost:3306/guess_game";
            String username = "root";
            String password = "";

            // Establish the database connection
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database.");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle any errors that occur during the connection process
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            // Close the database connection
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected from the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean createAccount(String username, String password) {
        try {
            // Prepare the SQL statement for account creation
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the SQL statement
            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            // Handle any errors that occur during the account creation process
            e.printStackTrace();
            return false;
        } finally {
            // Close the database connection when you're done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean login(String username, String password) {
        try {

            // Prepare the SQL statement for login validation
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the SQL statement
            ResultSet resultSet = statement.executeQuery();

            // Check if there is a matching record
            boolean success = resultSet.next();

            // Close the database resources
            resultSet.close();
            statement.close();

            return success;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   
}
