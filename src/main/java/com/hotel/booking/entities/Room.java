package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Where(clause="deleted=0")
@Table(name = DBConstants.Documents.ROOMS)
public class Room extends BaseEntity{
    @NotNull
    @Column(name = "name")    
    private String name;

    @Column(length = 50, unique = true)
    private String email;

    @NotNull
    @Column(name = "phone_number", length = 30, unique = true)
    private String phoneNumber;

    @Column(name = "total_price", columnDefinition = "default 0")
    private Double totalPrice;

    @Column(columnDefinition = "text")
    private String address;

    @Column(columnDefinition = "text")
    private String avatar;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = Boolean.FALSE;
}
