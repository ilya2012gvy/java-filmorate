package controller.storage.dao;

import controller.storage.UserStorage;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Component
@Slf4j
public class UserDbStorage implements UserStorage {
    private final JdbcTemplate jdbcTemplate;

    public UserDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private User makeUser(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("user_id");
        String email = rs.getString("email");
        String login = rs.getString("login");
        String name = rs.getString("name");
        LocalDate birthday = rs.getDate("birthday").toLocalDate();
        return new User(id, email, login, name, birthday);
    }

    @Override
    public User addUser(User user) {
        String sql = "insert into users(email, login, name, birthday)" + "value (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getLogin(), user.getName(), user.getBirthday());
        return user;
    }

    @Override
    public User updateUser(User user) {
        String sql = "update into set" + " email = ?, login = ?, name = ?, birthday = ?" + "where user_id = ?";
        jdbcTemplate.update(sql, user.getEmail(), user.getLogin(), user.getName(), user.getBirthday(), user.getId());
        return user;
    }

    @Override
    public int deleteUser(User user) {
        String sql = "delete from users" + "where user_id = ?";
        return jdbcTemplate.update(sql, user);
    }

    @Override
    public Collection<User> allUser() {
        String sql = "select * from users";
        return Collections.singleton(jdbcTemplate.query(sql, this::makeUser));
    }

    @Override
    public int addFriend(Long ids, Long userIds) {
        String sql = "insert into friends (user_id, film_id, status)" + "value (?, ?, ?)";
        return jdbcTemplate.update(sql, ids, userIds);
    }

    @Override
    public int deleteFriend(Long ids, Long userIds) {
        String sql = "delete from friends" + "where user_id and film_id";
       return jdbcTemplate.update(sql, ids, userIds);
    }

    @Override
    public Set<Long> returnListFriend() {
        String sql = "select * from friends";
        return Objects.requireNonNull(jdbcTemplate.query(sql, this::makeUser)).getFriends();
    }
}
