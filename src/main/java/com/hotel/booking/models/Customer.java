package com.hotel.booking.models;

import com.hotel.booking.constants.DBConstants;

import javax.persistence.*;

@Entity
@Table(name = DBConstants.Documents.CUSTOMERS)
public class Customer  extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Double totalPrice;

    private String address;


}