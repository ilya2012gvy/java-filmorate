package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private Integer id; // целочисленный идентификатор
    @NotBlank
    private String name; // название
    private String description; // описание
}
