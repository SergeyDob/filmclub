package onpu.op.edu.filmclub.controller;

import onpu.op.edu.filmclub.entity.Attendance;
import onpu.op.edu.filmclub.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Додано імпорт для List

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }

    @GetMapping("/member/{memberId}")
    public List<Attendance> getAttendancesByMember(@PathVariable Long memberId) {
        return attendanceService.getAttendancesByMember(memberId);
    }

    @GetMapping("/screening/{screeningId}")
    public List<Attendance> getAttendancesByScreening(@PathVariable Long screeningId) {
        return attendanceService.getAttendancesByScreening(screeningId);
    }
}