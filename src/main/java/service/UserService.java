package service;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import storage.UserStorage;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;

@Slf4j
@Service
public class UserService {
    private final UserStorage userStorage;

    @Autowired
    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public User addUser(@Valid @RequestBody User user) { // создание пользователя
        return userStorage.addUser(user);
    }

    public User updateUser(@Valid @RequestBody User user) { // обновление пользователя
        return userStorage.updateUser(user);
    }

    public User deleteUser(@Valid @RequestBody User user) { // удаление пользователя
        return userStorage.deleteUser(user);
    }

    public Collection<User> allUser() { // получение списка всех пользователей
        return userStorage.allUser();
    }

    public User addFriend(Long ids, Long userIds) { // добавление в друзья
       return userStorage.addFriend(ids, userIds);
    }

    public User deleteFriend(Long ids, Long userIds) { // удаление из друзей
       return userStorage.deleteFriend(ids, userIds);
    }

    public Set<Long> returnListFriend() { // возвращаем список пользователей, являющихся его друзьями
       return userStorage.returnListFriend();
    }
}
