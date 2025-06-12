package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovieId(Long movieId);
    List<Review> findByMemberId(Long memberId);

    long countByMemberId(Long memberId);
}