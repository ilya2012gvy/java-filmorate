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
    public int deleteFilm(@Valid @RequestBody Film film) { // удаление фильма
        return filmService.deleteFilm(film);
    }

    @GetMapping
    public List<Film> allFilm() { // получение всех фильмов
        return filmService.allFilm();
    }

    @PutMapping("/films/{id}/like/{userId}")
    public int likesTheMovie(@PathVariable int id, @PathVariable Long userId) { // пользователь ставит лайк фильму
       return filmService.likesTheMovie(id, userId);
    }

    @DeleteMapping("/films/{id}/like/{userId}")
    public int likesTheDelete(@PathVariable int id, @PathVariable int userId) { // пользователь удаляет лайк
       return filmService.likesTheDelete(id, userId);
    }

    @GetMapping("/films/popular?count={count}")
    public List<Film> returnListAll(@PathVariable int count) { // возвращает список из первых фильмов по количеству лайков
       return filmService.returnListAll(count);
    }
}