package controller;

import exception.ValidationException;
import model.Film;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/films")
public class FilmController {
    private final List<Film> films = new ArrayList<>();
    private int id = 1;

    @PostMapping
    public Film addFilm(@RequestBody Film film) { // добавление фильма
        if (validation(film)) {
            film.setId(id++);
            films.add(film);
            log.info("Фильм добавлен: {}", film);
        }
        return film;
    }

    @PutMapping
    public Film updateFilm(@RequestBody Film film) { // обновление фильма
        if (validation(film)) {
            films.add(film);
            log.info("Фильм обновлён: {}", film);
        }
        return film;
    }

    @GetMapping
    public List<Film> allFilm() { // получение всех фильмов
        log.info("Количество фильмов: {}", films.size());
        return films;
    }

    private boolean validation(Film film) { // Обработка ошибок
        if (film.getName() == null || film.getName().isBlank()) {
            throw new ValidationException("Фильм не может быть пустым!");
        }
        if (film.getDescription().length() > 200) {
            throw new ValidationException("Фильм не может содержать больше 200 символов!");
        }
        if (film.getReleaseDate().isBefore(LocalDate.of(1895, 12, 28))) {
            throw new ValidationException("Фильм не может быть раньше 1895 года!");
        }
        if (film.getDuration() < 0) {
            throw new ValidationException("Фильм не может содержать отрицательное количество символов!");
        }
        return false;
    }
}