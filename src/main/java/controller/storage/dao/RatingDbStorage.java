package controller.storage.dao;

import controller.storage.RatingStorage;
import lombok.extern.slf4j.Slf4j;
import model.Rating;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class RatingDbStorage implements RatingStorage {
    private final JdbcTemplate jdbcTemplate;

    public RatingDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Rating makeRating(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("genre_id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        return new Rating(id, name, description);
    }

    @Override
    public List<Rating> allRating() {
        String sql = "select * from rating";
        return Collections.singletonList(jdbcTemplate.query(sql, this::makeRating));
    }

    @Override
    public Rating addRating() {
        String sql = "select * from rating" + " where rating_id = ?";
        return jdbcTemplate.query(sql, this::makeRating);
    }
}
