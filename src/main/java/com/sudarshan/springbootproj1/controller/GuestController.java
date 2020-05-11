package com.sudarshan.springbootproj1.controller;

import com.sudarshan.springbootproj1.data.entity.Guest;
import com.sudarshan.springbootproj1.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/guests")
public class GuestController {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public Iterable<Guest> getGuests() {
        return guestRepository.findAll();
    }
}
