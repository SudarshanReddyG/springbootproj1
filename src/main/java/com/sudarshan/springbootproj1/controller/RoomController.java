package com.sudarshan.springbootproj1.controller;

import com.sudarshan.springbootproj1.data.entity.Room;
import com.sudarshan.springbootproj1.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public Iterable<Room> getRooms() {
        return roomRepository.findAll();
    }
}
