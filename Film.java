import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Film {
    private Long id;

    private String title;

    private String director;

    private LocalDate date;

    private String description;

    private MovieType filmType;

    private List<String> actors;

    public Film(Long id) {
        this.id = id;
    }

    public Film(Long id, String title, String director, LocalDate date, String description, MovieType filmType, List<String> actors) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.date = date;
        this.description = description;
        this.filmType = filmType;
        this.actors = actors;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MovieType getFilmType() {
        return filmType;
    }

    public void setFilmType(MovieType filmType) {
        this.filmType = filmType;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id.equals(film.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", filmType=" + filmType +
                ", actors=" + actors +
                '}';
    }
}

