package com.hotel.booking.repositories;

import com.hotel.booking.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.name LIKE %?1%" + " OR u.username LIKE %?1%" + " OR u.email LIKE %?1%")
    Page<User> listUsers(String searchText, Pageable pageable);
}
