package Medicare.Medicare.DAO;

import Medicare.Medicare.Entity.User;

import java.sql.*;
import java.util.List;

public class JdbcUserDAO implements UserDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String JDBC_USERNAME = "springstudent";
    private static final String JDBC_PASSWORD = "springstudent";

    private static final String REGISTER_USER_QUERY = "INSERT INTO users (username, password) VALUES (?, ?)";
    private static final String LOGIN_USER_QUERY = "SELECT * FROM users WHERE username=? AND password=?";

    @Override
    public void registerUser(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(REGISTER_USER_QUERY)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/*
    @Override
    public void registerUser(User user) {

    }

 */

    @Override
    public User loginUser(String username, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(LOGIN_USER_QUERY)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public List<User> findUsersByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findUsersByEmail(String email) {
        return null;
    }
}

