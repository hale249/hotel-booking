package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Where(clause="deleted=0")
@Table(name = DBConstants.Documents.COMMENTS)
public class Contact extends BaseEntity {

    @Column(name = "name", length = 128)
    private String name;

    @NotNull
    @Column(length = 128)
    private String email;

    @NotNull
    @Column(length = 128)
    private String phoneNumber;

    @NotNull
    @Column(length = 255)
    private String subject;

    @NotNull
    @Column(columnDefinition = "text")
    private String message;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = Boolean.FALSE;
}
