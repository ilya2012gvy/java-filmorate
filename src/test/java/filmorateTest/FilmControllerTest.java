package filmorateTest;

import model.Film;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootApplication
@SpringBootTest
public class FilmControllerTest {
    private static final Film films = new Film();
    private static final Film updateFilms = new Film();

    @Test
    public void addFilmTest() {
        films.setName("Name");
        films.setDescription("Description");
        films.setReleaseDate(LocalDate.of(2023, 3, 17));
        films.setDuration(12);
    }

    @Test
    public void updateFilmTest() {
        films.setName("Name");
        films.setDescription("Description");
        films.setReleaseDate(LocalDate.of(2023, 3, 17));
        films.setDuration(12);

        updateFilms.setName("Name-2");
        updateFilms.setDescription("Description-2");
        updateFilms.setReleaseDate(LocalDate.of(2024, 4, 18));
        updateFilms.setDuration(17);
    }

    @Test
    public void allFilmTest() {
        films.setName("Name");
        films.setDescription("Description");
        films.setReleaseDate(LocalDate.of(2023, 3, 17));
        films.setDuration(12);

        films.setName("Name-2");
        films.setDescription("Description-2");
        films.setReleaseDate(LocalDate.of(2025, 5, 19));
        films.setDuration(15);
    }
}
