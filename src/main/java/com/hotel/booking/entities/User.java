package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = DBConstants.Documents.USERS)
public class User extends BaseEntity {

    @Column(name = "name", length = 128)
    private String name;

    private String address;

    @NotNull
    @NotBlank
    @Column(length = 128)
    private String username;

    @NotNull
    @NotBlank
    @Column(unique = true, length = 128)
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @Column(name = "is_active", columnDefinition = "tinyint(1) default 1")
    private Boolean active;

    @Column(columnDefinition = "text")
    private String avatar;

    private Long birthday;
}
