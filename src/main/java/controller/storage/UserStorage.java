package controller.storage;

import model.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;

public interface UserStorage {
    User addUser(@Valid @RequestBody User user); // создание пользователя

    User updateUser(@Valid @RequestBody User user); // обновление пользователя

    int deleteUser(@Valid @RequestBody User user); // удаление пользователя

    Collection<User> allUser(); // получение списка всех пользователей

    int addFriend(Long ids, Long userIds); // добавление в друзья

    int deleteFriend(Long ids, Long userIds); // удаление из друзей

    Set<Long> returnListFriend(); // возвращаем список пользователей, являющихся его друзьями
}
