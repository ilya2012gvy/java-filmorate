package controller;

import lombok.extern.slf4j.Slf4j;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import service.GenreService;

import java.util.List;

@Slf4j
@RestController
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genre")
    public List<Genre> allGenre() {
        return genreService.allGenre();
    }

    @PutMapping("/genre/{id}")
    public Genre addGenre() {
        return genreService.addGenre();
    }
}
