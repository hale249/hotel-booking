package com.hotel.booking.repositories;

import com.hotel.booking.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    @Query("SELECT r FROM Room r WHERE r.name LIKE %?1%")
    Page<Room> listRooms(String searchText, Pageable pageable);

    @Modifying
    @Query("update Room r set r.deleted=true where r.id = ?1")
    void deleteById(Long id);
}
