package com.sudarshan.springbootproj1.controller;

import com.sudarshan.springbootproj1.bussiness.domain.RoomReservation;
import com.sudarshan.springbootproj1.bussiness.service.ReservationService;
import com.sudarshan.springbootproj1.web.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/allreservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getReservations(@RequestParam(value = "dateString", required = false) String dateString) {
        Date date = DateUtils.createDateFromDateString(dateString);
        return reservationService.getRoomReservationForDate(date);
    }
}
