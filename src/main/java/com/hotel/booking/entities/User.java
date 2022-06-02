package com.hotel.booking.entities;

import com.hotel.booking.constants.DBConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Where(clause = "deleted=0")
@Table(name = DBConstants.Documents.USERS)
public class User extends BaseEntity {

    @Column(name = "name", length = 128)
    private String name;

    private String address;

    @NotNull
    @Column(length = 128)
    private String username;

    @NotNull
    @Column(unique = true, length = 128)
    private String email;

    @NotNull
    private String password;

    @Column(name = "is_active", columnDefinition = "boolean default false")
    private boolean enabled;

    @Column(columnDefinition = "text")
    private String avatar;

    private Long birthday;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = Boolean.FALSE;
}
