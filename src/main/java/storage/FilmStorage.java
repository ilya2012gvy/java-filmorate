package storage;

import model.Film;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface FilmStorage {
    Film addFilm(@Valid @RequestBody Film film); // добавление фильма

    Film updateFilm(@Valid @RequestBody Film film); // обновление фильма

    int deleteFilm(@Valid @RequestBody Film film); // удаление фильма

    List<Film> allFilm(); // получение всех фильмов

    int likesTheMovie(int ids, Long filmIds); // пользователь ставит лайк фильму

    int likesTheDelete(int ids, int filmIds); // пользователь удаляет лайк

    List<Film> returnListAll(int count); // возвращает список из первых фильмов по количеству лайков
}
