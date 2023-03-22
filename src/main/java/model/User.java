package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class User {
    private Integer id; // целочисленный идентификатор
    private String email; // электронная почта
    private String login; // логин пользователя
    private String name; // название
    private LocalDate birthday; // дата рождения
}