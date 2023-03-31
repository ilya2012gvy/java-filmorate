package storage;

import exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Component
public class InMemoryUserStorage implements UserStorage {
    private final Map<String, User> users = new HashMap<>();
    private Set<Long> friends = new HashSet<>();
    private static int id = 0;

    private static Integer getNextId() {
        return id++;
    }

    @Override
    public User addUser(@Valid @RequestBody User user) { // создание пользователя
        if (validation(user)) {
            user.setId(getNextId());
            users.put(user.getEmail(), user);
            log.info("Пользователь создан: {}", user);
        }
        return user;
    }

    @Override
    public User updateUser(@Valid @RequestBody User user) { // обновление пользователя
        if (validation(user)) {
            users.put(user.getEmail(), user);
            log.info("Пользователь обновлён: {}", user);
        }
        return user;
    }

    @Override
    public User deleteUser(@Valid @RequestBody User user) { // удаление пользователя
        if (validation(user)) {
            if (users.containsKey(user.getId())) {
                users.remove(user.getId());
                log.info("Пользователь удалён: {}", user);
            }
        }
        return user;
    }

    @Override
    public Collection<User> allUser() { // получение списка всех пользователей
        log.info("Количество пользователей: {}", users.size());
        return users.values();
    }

    @Override
    public User addFriend(Long ids, Long userIds) { // добавление в друзья
            User user = getUser(ids);
            User newUser = getUser(userIds);

        if (user != null && newUser != null) {
            friends = user.getFriends();
            friends.add(userIds);
            user.setFriends(friends);

            friends = newUser.getFriends();
            friends.add(ids);
            newUser.setFriends(friends);
        }
        return updateUser(user);
    }

    @Override
    public User deleteFriend(Long ids, Long userIds) { // удаление из друзей
        User user = getUser(ids);
        User newUser = getUser(userIds);

        if (user != null && newUser != null) {
            user = deleteUser(newUser);
        }
        return updateUser(user);
    }

    @Override
    public Set<Long> returnListFriend() { // возвращаем список пользователей, являющихся его друзьями
        return friends;
    }

    private User getUser(Long ids) {
        if (users.containsKey(ids)) {
            return users.get(ids);
        }
        return null;
    }

    private boolean validation(User user) { // Обработка ошибок
        if (user.getEmail() == null || !user.getEmail().contains("@") || user.getEmail().isBlank()) {
            throw new ValidationException("Адрес электронной почты не может быть пустым или не содержит символ: @");
        }
        if (user.getLogin() == null || user.getLogin().isBlank()) {
            throw new ValidationException("Логин не может быть пустым или иметь пробелы!");
        }
        if (user.getName() == null || user.getName().isBlank()) {
            throw new ValidationException("Имя не должно быть пустым, иначе будет использован логин!");
        }
        if (user.getBirthday().isBefore(LocalDate.now())) {
            throw new ValidationException("День рождения не может быть из будущего!");
        }
        return false;
    }
}
