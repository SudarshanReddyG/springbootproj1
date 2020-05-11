package com.sudarshan.springbootproj1.web;

import com.sudarshan.springbootproj1.bussiness.service.GuestService;
import com.sudarshan.springbootproj1.data.entity.Guest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(GuestWebController.class)
public class GuestWebControllerTest {

    @MockBean
    private GuestService guestService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getGuestDetails() throws Exception {
        Guest guest1 = new Guest();
        guest1.setAddress("1-20/1, Sai Colony");
        guest1.setCountry("India");
        guest1.setEmailAddress("ABC@abc.com");
        guest1.setFirstName("Sudarshan");
        guest1.setLastName("Reddy");
        guest1.setGuestId(1);
        guest1.setState("Telagana");
        guest1.setPhoneNumber("99999999999");

        List<Guest> guests = new ArrayList<>();
        guests.add(guest1);

        given(guestService.getSortedGuestList()).willReturn(guests);

        this.mockMvc.perform(get("/allguests"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sudarshan")));
    }
}
