package storage.dao;

import model.Film;
import org.springframework.jdbc.core.JdbcTemplate;
import storage.FilmStorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class FilmDbStorage implements FilmStorage {
    private final JdbcTemplate jdbcTemplate;

    public FilmDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Film makeFilm(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("film_id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        LocalDate release_date = rs.getDate("release_date").toLocalDate();
        int duration = rs.getInt("duration");
        return new Film(id, name, description, release_date, duration);
    }

    @Override
    public Film addFilm(Film film) {
        String sql = "insert into films(name, description, release_date, duration)" + "value (?, ?, ?, ?)";
        jdbcTemplate.update(sql, film.getName(), film.getDescription(), film.getReleaseDate(), film.getDuration());
        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        String sql = "update into set" + " name = ?, description = ?, release_date = ?, duration = ?" + "where film_id = ?";
        jdbcTemplate.update(sql, film.getName(), film.getDescription(), film.getReleaseDate(), film.getDuration(),
                film.getId());
        return film;
    }

    @Override
    public int deleteFilm(Film film) {
        String sql = "delete from films" + "where film_id = ?";
        return jdbcTemplate.update(sql, film);
    }

    @Override
    public List<Film> allFilm() {
        String sql = "select * from films";
        return Collections.singletonList(jdbcTemplate.query(sql, this::makeFilm));
    }

    @Override
    public int likesTheMovie(int ids, Long filmIds) {
        String sql = "insert into likes (user_id, film_id)" + "value (?, ?)";
        return jdbcTemplate.update(sql, ids, filmIds);
    }

    @Override
    public int likesTheDelete(int ids, int filmIds) {
        String sql = "delete from likes" + "where user_id and film_id";
        return jdbcTemplate.update(sql, ids, filmIds);
    }

    @Override
    public List<Film> returnListAll(int count) {
        String sql = "select * from likes";
        return Collections.singletonList(jdbcTemplate.query(sql, this::makeFilm));
    }
}
