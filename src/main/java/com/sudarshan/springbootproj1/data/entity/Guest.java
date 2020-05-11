package com.sudarshan.springbootproj1.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GUEST")
public @Data class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guestSeq")
    @SequenceGenerator(name = "guestSeq", sequenceName = "GUEST_SEQ", allocationSize = 1)
    @Column(name = "GUEST_ID")
    private long guestId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name="STATE")
    private String state;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
}
