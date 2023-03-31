package controller;

import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import service.FilmService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public Film addFilm(@Valid @RequestBody Film film) { // добавление фильма
        return filmService.addFilm(film);
    }

    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) { // обновление фильма
        return filmService.updateFilm(film);
    }

    @DeleteMapping
    public Film deleteFilm(@Valid @RequestBody Film film) { // удаление фильма
        return filmService.deleteFilm(film);
    }

    @GetMapping
    public List<Film> allFilm() { // получение всех фильмов
        return filmService.allFilm();
    }

    @PutMapping("/films/{id}/like/{userId}")
    public Film likesTheMovie(int ids, Long filmIds) { // пользователь ставит лайк фильму
       return filmService.likesTheMovie(ids, filmIds);
    }

    @DeleteMapping("/films/{id}/like/{userId}")
    public Film likesTheDelete(int ids, int filmIds) { // пользователь удаляет лайк
       return filmService.likesTheDelete(ids, filmIds);
    }

    @GetMapping("/films/popular?count={count}")
    public List<Film> returnListAll(int count) { // возвращает список из первых фильмов по количеству лайков
       return filmService.returnListAll(count);
    }
}