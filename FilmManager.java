import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FilmManager {
    private List<Film> allFilms = new ArrayList<>();

    public FilmManager() {
        Film film1 = new Film(1L,"The Dark Night","Christopher Nolan",
                LocalDate.of(2008, Month.NOVEMBER,12),"When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, " +
                "Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                MovieType.ACTION, List.of("Christian Bale","Heath Ledger","Aaron Eckhart"));
        Film film2 = new Film(2L,"Esaretin Bedeli","Frank Darabont",
                LocalDate.of(1994,Month.JANUARY,12),
                "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.",MovieType.SCIENCE_FICTION,List.of("",""));
        
        allFilms.add(film1);
        allFilms.add(film2);
    }

    public List<Film> getAllFilms(){
        return this.allFilms;
    }

    public void searchAllFilms(Long id) {
        for (Film film : allFilms) {
            if (film.getId().equals(id)) {
                System.out.println("Aradığınız film: " + film.getTitle());
                return;
            }
        }
        throw new RuntimeException("Aradğınız film bulunamadı.");
    }

    public Film updateFilm(Film film) {
        for (Film filmToUpdate : allFilms) {
            if (filmToUpdate.getId().equals(film.getId())) {
                filmToUpdate.setFilmType(film.getFilmType() == null ? filmToUpdate.getFilmType() : film.getFilmType());
                filmToUpdate.setDate(film.getDate() == null ? filmToUpdate.getDate() : film.getDate());
                filmToUpdate.setActors(film.getActors() == null ? filmToUpdate.getActors() : film.getActors());
                filmToUpdate.setDirector(film.getDirector() == null ? filmToUpdate.getDirector() : film.getDirector());
                filmToUpdate.setDescription(film.getDescription() == null ? filmToUpdate.getDescription() : film.getDescription());
                filmToUpdate.setTitle(film.getTitle() == null ? filmToUpdate.getTitle() : film.getTitle());
                System.out.println(filmToUpdate.getId() + " Güncellendi.");
                return filmToUpdate;
            }
        }
        throw new RuntimeException("Aradğınız film bulunamadı.");
    }


    public void removeFilm(Long id) {
        for (Film film : allFilms) {
            if (film.getId().equals(id)) {
                allFilms.remove(film);
                System.out.println("Film silindi.");
            }
        }
    }

    public Film addFilm(Film film) {
        allFilms.add(film);
        System.out.println("Film eklendi.");
        return film;
    }


}
