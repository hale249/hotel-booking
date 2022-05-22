package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Where(clause="deleted=0")
@Table(name = DBConstants.Documents.COMMENTS)
public class Comment extends BaseEntity {

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "replyId")
    private Long replyId;

    @NotNull
    @Column(length = 128)
    private String email;

    @NotNull
    @Column(unique = true, length = 128)
    private String message;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = Boolean.FALSE;
}
