package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private Integer id; // целочисленный идентификатор
    private String name; // название
    private String description; // описание
}
