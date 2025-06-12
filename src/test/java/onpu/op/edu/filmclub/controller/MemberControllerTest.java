package onpu.op.edu.filmclub.controller;

import onpu.op.edu.filmclub.entity.Member;
import onpu.op.edu.filmclub.entity.Attendance;
import onpu.op.edu.filmclub.entity.Screening;
import onpu.op.edu.filmclub.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MemberControllerTest {

    private MockMvc mockMvc;
    private MemberService memberService;

    @BeforeEach
    public void setUp() {

        memberService = Mockito.mock(MemberService.class);

        MemberController memberController = new MemberController(memberService);

        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    @Test
    public void testGetAllMembers() throws Exception {
        // Створюємо Screening об’єкт
        Screening screening = new Screening();
        screening.setId(1L); // Ініціалізуємо id для уникнення null

        Attendance attendance1 = new Attendance();
        attendance1.setScreening(screening);

        Attendance attendance2 = new Attendance();
        attendance2.setScreening(screening);

        Member member1 = new Member();
        member1.setAttendances(Collections.singletonList(attendance1));

        Member member2 = new Member();
        member2.setAttendances(Collections.singletonList(attendance2));

        when(memberService.getAllMembers()).thenReturn(Arrays.asList(member1, member2));

        mockMvc.perform(get("/api/members"))
                .andExpect(status().isOk());
    }
}