package Medicare.Medicare.Services;

import Medicare.Medicare.Entity.User;
import Medicare.Medicare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.MBeanRegistrationException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) throws RegistrationException{
        // Implement registration logic, such as validating username and password uniqueness
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RegistrationException("Username already exists");
        }

        if (userRepository.existsByPassword(user.getPassword())) {
            throw new RegistrationException("Password already exists");
        }
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        userRepository.save(user);
    }
    public User loginUser(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }

    // Add more methods for fetching user details, updating profile,
    // Add more services as needed...

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return (User) userRepository.findByEmail(email);
    }

    public void updateUserProfile(User updatedUser) {
        User existingUser = userRepository.findById(updatedUser.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            //existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            //existingUser.setFullName(updatedUser.getFullName());
            // Update other fields as needed
            userRepository.save(existingUser);
        }
    }
}
