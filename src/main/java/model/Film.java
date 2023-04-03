package model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
public class Film {
    private Integer id; // целочисленный идентификатор
    @NotBlank(message = "Фильм не может быть пустым!")
    private String name; // название
    @Size(max = 200, message = "Фильм не может содержать больше 200 символов!")
    private String description; // описание
    private LocalDate releaseDate; // дата релиза
    @Positive(message = "Фильм не может содержать отрицательное количество символов!")
    private int duration; // продолжительность фильма
    private Set<Long> likes; // лайки
}