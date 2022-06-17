package com.hotel.booking.services;

import com.hotel.booking.entities.Room;
import com.hotel.booking.utils.pagination.Paged;

public interface RoomService {
    Paged<Room> listRooms(int current, int pageSize, String searchText);

    Room create(Room room);

    Room findById(Long id);

    Room update(Long id, Room room);

    void deleteById(Long roomId);
}
