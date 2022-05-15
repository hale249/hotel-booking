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
@Table(name = DBConstants.Documents.USERS)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 128)
    private String firstName;

    @Column(name = "last_name", length = 128)
    private String lastName;

    private String address;

    @NotNull
    @Column(length = 128)
    private String username;

    @NotNull
    @Column(unique = true, length = 128)
    private String email;

    @NotNull
    private String password;

    @Column(name = "is_active", columnDefinition = "tinyint(1) default 1")
    private Boolean active;

    @Column(columnDefinition = "text")
    private String avatar;

    private Long birthday;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
