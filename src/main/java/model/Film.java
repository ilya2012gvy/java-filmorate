package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public Film(Integer id, String name, String description, LocalDate releaseDate, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }
}