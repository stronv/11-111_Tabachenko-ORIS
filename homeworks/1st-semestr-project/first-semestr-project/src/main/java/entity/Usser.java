package entity;

public class Usser {
    private Integer id;
    private String email;
    private String username;
    private String password;

    public Usser(){}

    public Usser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usser(String email, String username, String password) {
        this.id = null;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Usser(Integer id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Usser(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usser usser = (Usser) o;

        if (!username.equals(usser.username)) return false;
        return password != null ? password.equals(usser.password) : usser.password == null;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
