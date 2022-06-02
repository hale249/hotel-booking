package com.hotel.booking.repositories;

import com.hotel.booking.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    Page<Room> listRooms(String searchText, Pageable pageable);
}
