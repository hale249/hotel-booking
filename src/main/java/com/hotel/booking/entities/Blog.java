package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Where(clause="deleted=0")
@Table(name = DBConstants.Documents.BLOG)
public class Blog extends BaseEntity implements Serializable {
    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "sub_title", length = 255)
    private String subTitle;

    @Column(columnDefinition = "text")
    private String image;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "status", columnDefinition = "boolean default true")
    private boolean status;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Comment> comments;
}
