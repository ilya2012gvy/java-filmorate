package controller.storage.dao;

import controller.storage.GenreStorage;
import lombok.extern.slf4j.Slf4j;
import model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
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
