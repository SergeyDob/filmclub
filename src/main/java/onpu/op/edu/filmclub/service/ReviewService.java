package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.Review;
import onpu.op.edu.filmclub.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovie_Id(movieId);
    }

    public List<Review> getReviewsByMember(Long memberId) {
        return reviewRepository.findByMember_Id(memberId);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public void deleteReviewsByMemberId(Long memberId) {
        reviewRepository.deleteAllByMember_Id(memberId);
    }
}