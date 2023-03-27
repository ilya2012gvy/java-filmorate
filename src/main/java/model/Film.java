package model;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Film {
    private Integer id; // целочисленный идентификатор
    private String name; // название
    private String description; // описание
    private LocalDate releaseDate; // дата релиза
    private int duration; // продолжительность фильма
}