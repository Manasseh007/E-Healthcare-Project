package Medicare.Medicare.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    private long setId;

    private long getId;

    public User() {
    }

    public User(long userId, String username, String password, long setId, long getId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.setId = setId;
        this.getId = getId;
    }

    public long getGetId() {
        return getId;
    }

    public void setGetId(long getId) {
        this.getId = getId;
    }

    public long getSetId() {
        return setId;
    }

    public void setSetId(long setId) {
        this.setId = setId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(long id) {
    }

    public Long getId() {
        return getId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", setId=" + setId +
                ", getId=" + getId +
                '}';
    }
}
