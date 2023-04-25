package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id; // целочисленный идентификатор
    @Email(message = "Неверный адрес электронной почты!")
    private String email; // электронная почта
    @NotBlank(message = "Логин не может быть пустым или иметь пробелы!")
    private String login; // логин пользователя
    @NotBlank(message = "Имя не должно быть пустым, иначе будет использован логин!")
    private String name; // название
    @Past(message = "День рождения не может быть из будущего!")
    private LocalDate birthday; // дата рождения
    private Set<Long> friends;

    public User(Integer id, String email, String login, String name, LocalDate birthday) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.name = name;
        this.birthday = birthday;
    }
}