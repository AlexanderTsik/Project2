package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.Config.MSSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseSteps {

    /**
     * Fetches the username and password from the database for a given user ID.
     *
     * @param id The ID of the user whose credentials are to be fetched.
     * @return An array containing the username at index 0 and password at index 1.
     */
    public String[] getCredentialsById(int id) {
        String[] credentials = new String[2]; // Index 0: username, Index 1: password

        String query = "SELECT username, password FROM Users WHERE id = ?";

        try (Connection connection = MSSQLConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the user ID in the query
            preparedStatement.setInt(1, id);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Retrieve the results
            if (resultSet.next()) {
                credentials[0] = resultSet.getString("username");
                credentials[1] = resultSet.getString("password");
            } else {
                throw new RuntimeException("No user found with ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching user credentials from the database.", e);
        }

        return credentials;
    }
}
