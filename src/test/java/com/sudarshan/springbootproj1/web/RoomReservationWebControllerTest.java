package com.sudarshan.springbootproj1.web;

import com.sudarshan.springbootproj1.bussiness.domain.RoomReservation;
import com.sudarshan.springbootproj1.bussiness.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationWebController.class)
public class RoomReservationWebControllerTest {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservations() throws Exception {
        String dateString = "2020-01-01";
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservationList = new ArrayList<>();
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setRoomName("Avengers");
        roomReservation.setDate(date);
        roomReservation.setLastName("End Game");
        roomReservation.setFirstName("Thanos");
        roomReservation.setGuestId(1);
        roomReservation.setRoomId(100);
        roomReservation.setRoomNumber("1000");
        roomReservationList.add(roomReservation);

        given(reservationService.getRoomReservationForDate(date)).willReturn(roomReservationList);

        this.mockMvc.perform(get("/reservations?dateString=2020-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("End Game, Thanos")));
    }
}
