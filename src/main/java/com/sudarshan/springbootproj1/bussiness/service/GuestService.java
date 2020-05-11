package com.sudarshan.springbootproj1.bussiness.service;

import com.sudarshan.springbootproj1.data.entity.Guest;
import com.sudarshan.springbootproj1.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getSortedGuestList() {
        Iterable<Guest> guestItr = guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        guestItr.forEach(guest -> guestList.add(guest));

        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        return guestList;
    }
}
