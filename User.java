import java.util.Objects;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private String password;
    private String eMail;
    private List<Film> films;

    public User(Long id, String name, String password, String eMail, List<Film> films) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.eMail = eMail;
        this.films = films;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
