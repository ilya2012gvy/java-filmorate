package storage.dao;

import model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import storage.GenreStorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GenreDbStorage implements GenreStorage {
    private final JdbcTemplate jdbcTemplate;

    public GenreDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Genre makeGenre(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("genre_id");
        String name = rs.getString("name");
        return new Genre(id, name);
    }
    @Override
    public List<Genre> allGenre() {
        String sql = "select * from genre";
        return Collections.singletonList(jdbcTemplate.query(sql, this::makeGenre));
    }

    @Override
    public Genre addGenre() {
        String sql = "select genre_id from genre" + " where film_id = ?";
        return jdbcTemplate.query(sql, this::makeGenre);
    }
}
