package dbConnection;

import org.junit.jupiter.api.Test;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseTests {

    private static final String QUERY = "SELECT * FROM `products` ";

    @Test
    public void callDatabaseMethod(){

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = ConnectionUtil.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println(id + "," + name );
            }
        } catch (SQLException e) {

            ConnectionUtil.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }


}
