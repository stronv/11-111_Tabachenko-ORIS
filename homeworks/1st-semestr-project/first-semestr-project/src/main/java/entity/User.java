package entity;

public class User {
    int id;
    String email;
    String username;
    String password;

    public User(String email, String username, String password) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(int id, String email, String username, String password) {
        super();
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
