package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = DBConstants.Documents.CUSTOMERS)
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 128)
    private String firstName;

    @Column(name = "last_name", length = 128)
    private String lastName;

    @NotNull
    @Column(length = 50, unique = true)
    private String email;

    @NotNull
    @Column(name = "phone_number", length = 30, unique = true)
    private String phoneNumber;

    @Column(length = 128)
    private String username;

    private String password;

    @Column(name = "total_price", columnDefinition = "default 0")
    private Double totalPrice;

    @Column(columnDefinition = "text")
    private String address;

    @Column(columnDefinition = "text")
    private String avatar;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}