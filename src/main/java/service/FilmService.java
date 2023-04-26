package service;

import lombok.extern.slf4j.Slf4j;
import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import controller.storage.FilmStorage;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Service
public class FilmService {
    private final FilmStorage filmStorage;

    @Autowired
    public FilmService(FilmStorage filmStorage) {
        this.filmStorage = filmStorage;
    }

    public Film addFilm(@Valid @RequestBody Film film) { // добавление фильма
        return filmStorage.addFilm(film);
    }

    public Film updateFilm(@Valid @RequestBody Film film) { // обновление фильма
        return filmStorage.updateFilm(film);
    }

    public int deleteFilm(@Valid @RequestBody Film film) { // удаление фильма
        return filmStorage.deleteFilm(film);
    }

    public List<Film> allFilm() { // получение всех фильмов
        return filmStorage.allFilm();
    }

    public int likesTheMovie(int ids, Long filmIds) { // пользователь ставит лайк фильму
        return filmStorage.likesTheMovie(ids, filmIds);
    }

    public int likesTheDelete(int ids, int filmIds) { // пользователь удаляет лайк
        return filmStorage.likesTheDelete(ids, filmIds);
    }

    public List<Film> returnListAll(int count) { // возвращает список из первых фильмов по количеству лайков
        return filmStorage.returnListAll(count);
    }
}
