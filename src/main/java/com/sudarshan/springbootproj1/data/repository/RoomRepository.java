package com.sudarshan.springbootproj1.data.repository;

import com.sudarshan.springbootproj1.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
