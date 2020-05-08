package com.sudarshan.springbootproj1.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM")
public @Data class Room {

    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;

    @Column(name="NAME")
    private String name;

    @Column(name="ROOM_NUMBER")
    private String roomNumber;

    @Column(name="BED_INFO")
    private String bedInfo;

}
