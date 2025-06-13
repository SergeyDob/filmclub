package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    long countByMemberId(Long memberId);

    List<Attendance> findByMemberId(Long memberId);

    List<Attendance> findByScreeningId(Long screeningId);
}