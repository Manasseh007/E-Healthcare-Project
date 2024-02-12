package Medicare.Medicare.DAO;

import Medicare.Medicare.Entity.User;

import java.util.List;

public interface UserDAO {
    void registerUser(User user);
    User loginUser(String username, String password);

    // Add more methods as need

    // Method to save a user
    void saveUser(User user);

    // Method to update a user
    void updateUser(User user);

    // Method to delete a user by ID
    void deleteUserById(Long id);

    // Method to find a user by ID
    User findUserById(Long id);

    // Method to find all users
    List<User> findAllUsers();

    // Method to find users by username
    List<User> findUsersByUsername(String username);

    // Method to find users by email
    List<User> findUsersByEmail(String email);

    // Add more methods as needed...
}
