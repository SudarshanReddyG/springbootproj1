package com.sudarshan.springbootproj1.bussiness.service;

import com.sudarshan.springbootproj1.bussiness.domain.RoomReservation;
import com.sudarshan.springbootproj1.data.entity.Guest;
import com.sudarshan.springbootproj1.data.entity.Reservation;
import com.sudarshan.springbootproj1.data.entity.Room;
import com.sudarshan.springbootproj1.data.repository.GuestRepository;
import com.sudarshan.springbootproj1.data.repository.ReservationRepository;
import com.sudarshan.springbootproj1.data.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final GuestRepository guestRepository;

    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository, GuestRepository guestRepository,
                              RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

    public List<RoomReservation> getRoomReservationForDate(Date date) {
        Iterable<Room> rooms = roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByResDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            Guest guest = guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setGuestId(reservation.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setDate(reservation.getResDate());
        });
        List<RoomReservation> roomReservationList = new ArrayList<>();
        for(long id : roomReservationMap.keySet()) {
            roomReservationList.add(roomReservationMap.get(id));
        }

        roomReservationList.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if(o1.getRoomName() == o2.getLastName()) {
                    o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });
        return roomReservationList;
    }
}
