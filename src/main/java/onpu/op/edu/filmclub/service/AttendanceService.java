package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.Attendance;
import onpu.op.edu.filmclub.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    // Нові методи
    public List<Attendance> getAttendancesByMember(Long memberId) {
        return attendanceRepository.findByMemberId(memberId);
    }

    public List<Attendance> getAttendancesByScreening(Long screeningId) {
        return attendanceRepository.findByScreeningId(screeningId);
    }
}