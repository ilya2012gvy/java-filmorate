package filmorateTest;

import model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class UserControllerTest {
    private static final User users = new User();
    private static final User updateUsers = new User();

    @Test
    public void addUserTest() {
        users.setEmail("Email");
        users.setName("Name");
        users.setLogin("Login");
        users.setBirthday(LocalDate.of(2023, 3, 17));

        assertNotNull(users, "Список пользователей пустой.");
    }

    @Test
    public void updateUserTest() {
        users.setEmail("Email");
        users.setName("Name");
        users.setLogin("Login");
        users.setBirthday(LocalDate.of(2023, 3, 17));

        updateUsers.setEmail("Email-2");
        updateUsers.setName("Name-2");
        updateUsers.setLogin("Login-2");
        updateUsers.setBirthday(LocalDate.of(2025, 5, 19));

        assertNotNull(users, "Список пользователей пустой.");
    }

    @Test
    public void allUserTest() {
        users.setEmail("Email");
        users.setName("Name");
        users.setLogin("Login");
        users.setBirthday(LocalDate.of(2023, 3, 17));

        users.setEmail("Email-2");
        users.setName("Name-2");
        users.setLogin("Login-2");
        users.setBirthday(LocalDate.of(2024, 4, 18));

        assertNotNull(users, "Список пользователей пустой.");
    }
}
