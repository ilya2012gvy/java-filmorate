package controller;

import lombok.extern.slf4j.Slf4j;
import model.Genre;
import model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RatingService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<Rating> allRating() {
        return ratingService.allRating();
    }

    @PutMapping
    public Rating addRating() {
        return ratingService.addRating();
    }
}
