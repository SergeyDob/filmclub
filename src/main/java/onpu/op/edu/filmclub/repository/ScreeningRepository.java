package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByMovieId(Long movieId);

    @Query("SELECT a.screening FROM Attendance a WHERE a.member.id = :memberId")
    List<Screening> findScreeningsByMemberId(@Param("memberId") Long memberId);
}