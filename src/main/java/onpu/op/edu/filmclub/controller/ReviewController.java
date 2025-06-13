package onpu.op.edu.filmclub.controller;

import onpu.op.edu.filmclub.entity.Review;
import onpu.op.edu.filmclub.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @GetMapping("/movie/{movieId}")
    public List<Review> getReviewsByMovie(@PathVariable Long movieId) {
        return reviewService.getReviewsByMovie(movieId);
    }

    @GetMapping("/member/{memberId}")
    public List<Review> getReviewsByMember(@PathVariable Long memberId) {
        return reviewService.getReviewsByMember(memberId);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return reviewService.saveReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    // Новий запит
    @DeleteMapping("/member/{memberId}")
    public void deleteReviewsByMember(@PathVariable Long memberId) {
        reviewService.deleteReviewsByMemberId(memberId);
    }
}