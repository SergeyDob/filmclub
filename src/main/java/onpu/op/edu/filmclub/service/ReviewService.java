package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.Review;
import onpu.op.edu.filmclub.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    public List<Review> getReviewsByMember(Long memberId) {
        return reviewRepository.findByMemberId(memberId);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}