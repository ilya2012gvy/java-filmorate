package model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
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
}