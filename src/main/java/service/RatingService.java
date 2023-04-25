package service;

import lombok.extern.slf4j.Slf4j;
import model.Rating;
import org.springframework.stereotype.Service;
import storage.RatingStorage;

import java.util.List;

@Slf4j
@Service
public class RatingService {
    private final RatingStorage ratingStorage;

    public RatingService(RatingStorage ratingStorage) {
        this.ratingStorage = ratingStorage;
    }

    public List<Rating> allRating() {
        return ratingStorage.allRating();
    }

    public Rating addRating() {
        return ratingStorage.addRating();
    }
}
