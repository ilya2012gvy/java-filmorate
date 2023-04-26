package service;

import lombok.extern.slf4j.Slf4j;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import controller.storage.GenreStorage;

import java.util.List;

@Slf4j
@Service
public class GenreService {
    private final GenreStorage genreStorage;

    @Autowired
    public GenreService(GenreStorage genreStorage) {
        this.genreStorage = genreStorage;
    }

    public List<Genre> allGenre() {
        return genreStorage.allGenre();
    }

    public Genre addGenre() {
        return genreStorage.addGenre();
    }
}
