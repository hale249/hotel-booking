package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column(columnDefinition = "text")
        private String image;

    private double price;

    private String unit;

    private String description;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<RoomTags> roomTag;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<RoomImages> roomImages;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = Boolean.FALSE;
}
