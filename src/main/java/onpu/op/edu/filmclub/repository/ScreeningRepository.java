package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    @Query("SELECT DISTINCT s FROM Attendance a JOIN a.screening s WHERE a.member.id = :memberId")
    List<Screening> findByMemberId(@Param("memberId") Long memberId);

    List<Screening> findByMovieId(Long movieId);
}