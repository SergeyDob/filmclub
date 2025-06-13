package onpu.op.edu.filmclub.controller;

import onpu.op.edu.filmclub.dto.MemberDTO;
import onpu.op.edu.filmclub.dto.AttendanceDTO;
import onpu.op.edu.filmclub.entity.Attendance;
import onpu.op.edu.filmclub.entity.Member;
import onpu.op.edu.filmclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map; // Додано імпорт для Map
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public Member createMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @GetMapping("/members")
    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return members.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/members/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id).orElse(null);
    }

    @PutMapping("/members/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        member.setId(id);
        return memberService.saveMember(member);
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    // Існуючі методи
    @GetMapping("/members/{id}/screenings")
    public List<AttendanceDTO> getMemberScreenings(@PathVariable Long id) {
        Member member = memberService.getMemberById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        return member.getAttendances().stream()
                .map(this::convertToAttendanceDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/members/{id}/stats")
    public Map<String, Long> getMemberStats(@PathVariable Long id) {
        return memberService.getMemberStats(id);
    }

    // Нові запити
    @GetMapping("/members/search/email")
    public List<Member> searchMembersByEmail(@RequestParam String email) {
        return memberService.searchMembersByEmail(email);
    }

    @GetMapping("/members/search/name")
    public List<Member> searchMembersByName(@RequestParam String name) {
        return memberService.searchMembersByName(name);
    }

    @GetMapping("/members/without-attendance")
    public List<Member> getMembersWithoutAttendance() {
        return memberService.getMembersWithoutAttendance();
    }

    @GetMapping("/members/with-reviews")
    public List<Member> getMembersWithReviews() {
        return memberService.getMembersWithReviews();
    }

    @GetMapping("/members/active")
    public List<Member> getActiveMembers(@RequestParam int minAttendance) {
        return memberService.getActiveMembers(minAttendance);
    }

    // Додані методи конвертації
    private MemberDTO convertToDTO(Member member) {
        return new MemberDTO(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getAttendances().stream()
                        .map(this::convertToAttendanceDTO)
                        .collect(Collectors.toList())
        );
    }

    private AttendanceDTO convertToAttendanceDTO(Attendance attendance) {
        return new AttendanceDTO(
                attendance.getId(),
                attendance.isAttended(),
                attendance.getScreening() != null ? attendance.getScreening().getId() : null
        );
    }
}