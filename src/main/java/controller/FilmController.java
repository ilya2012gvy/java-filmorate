package controller;

import exception.ValidationException;
import model.Film;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

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
        if (film.getName() == null || film.getName().isBlank()) {
            throw new ValidationException("Фильм с таким названием не найден!");
        }
        film.setId(id++);
        films.add(film);
        log.info("Фильм добавлен: {}", film);
        return film;
    }

    @PutMapping
    public Film updateFilm(@RequestBody Film film) { // обновление фильма
        if (film.getName() == null || film.getName().isBlank()) {
            throw new ValidationException("Фильм с таким названием не найден или не удалось обновить!");
        }
        films.add(film);
        log.info("Фильм обновлён: {}", film);
        return film;
    }

    @GetMapping
    public List<Film> allFilm() { // получение всех фильмов
        log.info("Количество фильмов: {}", films.size());
        return films;
    }
}

// logging.level.org.zalando.logbook=TRACE
// logging.level.ru.yandex.practicum.contollers=debug
// logging.level.root= DEBUG