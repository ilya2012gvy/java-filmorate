package storage;

import model.Genre;

import java.util.List;

public interface GenreStorage {
    List<Genre> allGenre();
    Genre addGenre();
}
