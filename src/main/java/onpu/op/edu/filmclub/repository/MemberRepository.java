package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByEmailContainingIgnoreCase(String email);

    List<Member> findByNameContainingIgnoreCase(String name);

    @Query("SELECT m FROM Member m WHERE m.attendances IS EMPTY")
    List<Member> findMembersWithoutAttendance();

    @Query("SELECT DISTINCT r.member FROM Review r")
    List<Member> findMembersWithReviews();

    @Query("SELECT m FROM Member m WHERE SIZE(m.attendances) > :minAttendance")
    List<Member> findMembersWithAttendanceMoreThan(int minAttendance);
}