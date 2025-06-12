package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}