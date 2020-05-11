package com.sudarshan.springbootproj1.data.repository;

import com.sudarshan.springbootproj1.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}
