package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.Member;
import onpu.op.edu.filmclub.entity.Screening;
import onpu.op.edu.filmclub.repository.MemberRepository;
import onpu.op.edu.filmclub.repository.ScreeningRepository;
import onpu.op.edu.filmclub.repository.ReviewRepository;
import onpu.op.edu.filmclub.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ScreeningRepository screeningRepository;
    private final AttendanceRepository attendanceRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository,
                         ScreeningRepository screeningRepository,
                         AttendanceRepository attendanceRepository,
                         ReviewRepository reviewRepository) {
        this.memberRepository = memberRepository;
        this.screeningRepository = screeningRepository;
        this.attendanceRepository = attendanceRepository;
        this.reviewRepository = reviewRepository;
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public List<Screening> getScreeningsForMember(Long memberId) {
        return screeningRepository.findByMemberId(memberId);
    }

    public Map<String, Long> getMemberStats(Long memberId) {
        long reviews = reviewRepository.countReviewsByMemberId(memberId);
        long visits = attendanceRepository.countByMemberId(memberId);
        Map<String, Long> stats = new HashMap<>();
        stats.put("reviewCount", reviews);
        stats.put("attendanceCount", visits);
        return stats;
    }

    // Нові методи
    public List<Member> searchMembersByEmail(String email) {
        return memberRepository.findByEmailContainingIgnoreCase(email);
    }

    public List<Member> searchMembersByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Member> getMembersWithoutAttendance() {
        return memberRepository.findMembersWithoutAttendance();
    }

    public List<Member> getMembersWithReviews() {
        return memberRepository.findMembersWithReviews();
    }

    public List<Member> getActiveMembers(int minAttendance) {
        return memberRepository.findMembersWithAttendanceMoreThan(minAttendance);
    }
}