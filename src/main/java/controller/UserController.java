package controller;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user) { // создание пользователя
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) { // обновление пользователя
        return userService.updateUser(user);
    }

    @DeleteMapping
    public User deleteUser(@Valid @RequestBody User user) { // удаление пользователя
        return userService.deleteUser(user);
    }

    @GetMapping
    public Collection<User> allUser() { // получение списка всех пользователей
        return userService.allUser();
    }

    @PutMapping("/users/{id}/friends/{friendId}")
    public User addFriend(@PathVariable Long id, @PathVariable Long friendId) { // добавление в друзья
       return userService.addFriend(id, friendId);
    }

    @DeleteMapping("/users/{id}/friends/{friendId}")
    public User deleteFriend(@PathVariable Long id, @PathVariable Long friendId) { // удаление из друзей
       return userService.deleteFriend(id, friendId);
    }

    @GetMapping("/users/{id}/friends")
    public Set<Long> returnListFriend() { // возвращаем список пользователей, являющихся его друзьями
       return userService.returnListFriend();
    }
}