package controller.storage;

import model.Rating;

import java.util.List;

public interface RatingStorage {
    List<Rating> allRating();
    Rating addRating();
}
