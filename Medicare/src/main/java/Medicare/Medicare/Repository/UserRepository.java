package Medicare.Medicare.Repository;

import Medicare.Medicare.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username
    User findByUsername(String username);

    // Find users by email
    List<User> findByEmail(String email);

    // Find users by username and password
    User findByUsernameAndPassword(String username, String password);

    // Find users by enabled status
    List<User> findByEnabled(boolean enabled);

    // Find users by username containing a keyword (case-insensitive)
    List<User> findByUsernameContainingIgnoreCase(String keyword);

    // Find users by email containing a keyword (case-insensitive)
    List<User> findByEmailContainingIgnoreCase(String keyword);

    // Find users by username or email containing a keyword (case-insensitive)
    List<User> findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(String usernameKeyword, String emailKeyword);

    // Find users by role
    List<User> findByRole(String role);

    // Find users by role and enabled status
    List<User> findByRoleAndEnabled(String role, boolean enabled);

    // Find users by role and username containing a keyword (case-insensitive)
    List<User> findByRoleAndUsernameContainingIgnoreCase(String role, String query);

    // Find users by role or enabled status
    List<User> findByRoleOrEnabled(String role, boolean enabled);

    // Find users by role and email containing a keyword (case-insensitive)
    List<User> findByRoleAndEmailContainingIgnoreCase(String role, String query);

    // Find users by role and username or email containing a keyword (case-insensitive)
    List<User> findByRoleAndUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(String role, String usernameKeyword, String emailKeyword);

    // Find users by role or username containing a keyword (case-insensitive)
    List<User> findByRoleOrUsernameContainingIgnoreCase(String role, String query);

    // Find users by role or email containing a keyword (case-insensitive)
    List<User> findByRoleOrEmailContainingIgnoreCase(String role, String query);

    // Find users by role or username or email containing a keyword (case-insensitive)
    List<User> findByRoleOrUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(String role, String usernameKeyword, String emailKeyword);

    boolean existsByUsername(String username);

    boolean existsByPassword(String password);

}

