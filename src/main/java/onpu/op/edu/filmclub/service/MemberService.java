package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.Member;
import onpu.op.edu.filmclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import onpu.op.edu.filmclub.repository.ScreeningRepository;
import onpu.op.edu.filmclub.repository.ReviewRepository;
import onpu.op.edu.filmclub.repository.AttendanceRepository;

import onpu.op.edu.filmclub.entity.Screening;

import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.orElse(null);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Autowired
    private ScreeningRepository screeningRepository;

    public List<Screening> getScreeningsForMember(Long memberId) {
        return screeningRepository.findScreeningsByMemberId(memberId);
    }

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Map<String, Long> getMemberStats(Long memberId) {
        long reviews = reviewRepository.countByMemberId(memberId);
        long visits = attendanceRepository.countByMemberId(memberId);

        Map<String, Long> stats = new HashMap<>();
        stats.put("reviewCount", reviews);
        stats.put("attendanceCount", visits);
        return stats;
    }
}