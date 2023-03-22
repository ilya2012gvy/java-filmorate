package controller;

import exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.web.bind.annotation.*;

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
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new ValidationException("Адрес электронной почты не может быть пустым.");
        }
        if (users.containsKey(user.getEmail())) {
            throw new ValidationException("Пользователь с электронной почтой " +
                    user.getEmail() + " уже зарегистрирован.");
        }
        user.setId(id++);
        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) { // обновление пользователя
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new ValidationException("Адрес электронной почты не может быть пустым.");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    @GetMapping
    public Collection<User> allUser() { // получение списка всех пользователей
        log.info("Количество пользователей: {}", users.size());
        return users.values();
    }
}