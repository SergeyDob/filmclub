package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMovie_Id(Long movieId);

    List<Review> findByMember_Id(Long memberId);

    void deleteAllByMember_Id(Long memberId);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.member.id = :memberId")
    long countReviewsByMemberId(@Param("memberId") Long memberId);
}