package storage;

import exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import model.Film;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class InMemoryFilmStorage implements FilmStorage {
    private final List<Film> films = new ArrayList<>();
    private UserStorage userStorage;
    private static int id = 0;

    private static Integer getNextId() {
        return id++;
    }

    @Override
    public Film addFilm(@Valid @RequestBody Film film) { // добавление фильма
        if (validation(film)) {
            film.setId(getNextId());
            films.add(film);
            log.info("Фильм добавлен: {}", film);
        }
        return film;
    }

    @Override
    public Film updateFilm(@Valid @RequestBody Film film) { // обновление фильма
        if (validation(film)) {
            films.add(film);
            log.info("Фильм обновлён: {}", film);
        }
        return film;
    }

    @Override
    public Film deleteFilm(@Valid @RequestBody Film film) { // удаление фильма
        if (validation(film)) {
            films.remove(film);
            log.info("Фильм удалён: {}", film);
        }
        return film;
    }

    @Override
    public List<Film> allFilm() { // получение всех фильмов
        log.info("Количество фильмов: {}", films.size());
        return films;
    }

    @Override
    public Film likesTheMovie(int ids, Long filmIds) { // пользователь ставит лайк фильму
        if (films.contains(ids) && userStorage.allUser().contains(filmIds)) {
            films.get(ids).getLikes().add(filmIds);
            log.info("Пользователь поставил лайк: {}", films);
        }
        return null;
    }

    @Override
    public Film likesTheDelete(int ids, int filmIds) { // пользователь удаляет лайк
        if (films.contains(ids) && userStorage.allUser().contains(filmIds)) {
            films.get(ids).getLikes().remove(filmIds);
            log.info("Пользователь удалил лайк: {}", films);
        }
        return null;
    }

    @Override
    public List<Film> returnListAll(int count) { // возвращает список из первых фильмов по количеству лайков
        return this.allFilm().stream()
                .sorted((p0, p1) -> p1.getLikes().size() - p0.getLikes().size())
                .limit(count)
                .collect(Collectors.toList());
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
