package controller;

import exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<String, User> users = new HashMap<>();
    private int id = 1;

    @PostMapping
    public User addUser(@RequestBody User user) { // создание пользователя
        if (validation(user)) {
            user.setId(id++);
            users.put(user.getEmail(), user);
            log.info("Пользователь создан: {}", user);
        }
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) { // обновление пользователя
        if (validation(user)) {
            users.put(user.getEmail(), user);
            log.info("Пользователь обновлён: {}", user);
        }
        return user;
    }

    @GetMapping
    public Collection<User> allUser() { // получение списка всех пользователей
        log.info("Количество пользователей: {}", users.size());
        return users.values();
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