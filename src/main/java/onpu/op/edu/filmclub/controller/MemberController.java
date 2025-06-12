package onpu.op.edu.filmclub.controller;

import onpu.op.edu.filmclub.dto.MemberDTO;
import onpu.op.edu.filmclub.dto.AttendanceDTO;
import onpu.op.edu.filmclub.entity.Attendance;
import onpu.op.edu.filmclub.entity.Member;
import onpu.op.edu.filmclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberService.getAllMembers(); // Викликаємо метод сервісу
        return members.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MemberDTO convertToDTO(Member member) {
        MemberDTO dto = new MemberDTO(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getAttendances().stream()
                        .map(this::convertToAttendanceDTO)
                        .collect(Collectors.toList())
        );
        return dto;
    }

    private AttendanceDTO convertToAttendanceDTO(Attendance attendance) {
        return new AttendanceDTO(
                attendance.getId(),
                attendance.isAttended(),
                attendance.getScreening() != null ? attendance.getScreening().getId() : null
        );
    }
}