package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Where(clause="deleted=0")
@Table(name = DBConstants.Documents.CUSTOMERS)
public class Customer {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "id_card")
    private String idCard;

    @NotNull
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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @JsonIgnore
    private Instant createdAt = Instant.now();

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonIgnore
    private Instant updatedAt = Instant.now();

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = Boolean.FALSE;
}