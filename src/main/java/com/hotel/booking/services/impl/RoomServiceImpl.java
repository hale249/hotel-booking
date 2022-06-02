package com.hotel.booking.services.impl;

import com.hotel.booking.entities.Room;
import com.hotel.booking.repositories.RoomRepository;
import com.hotel.booking.services.RoomService;
import com.hotel.booking.utils.pagination.Paged;
import com.hotel.booking.utils.pagination.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Paged<Room> listRooms(int current, int pageSize, String searchText) {
        PageRequest request = PageRequest.of(current - 1, pageSize, Sort.by(Sort.Direction.ASC, "id"));
//        Page<Room> roomPage = roomRepository.listRooms(searchText, request);
//        return new Paged<>(roomPage, Paging.of(roomPage.getTotalPages(), current, pageSize));
        return null;
    }

    @Override
    public Room create(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room findById(Long userId) {
        return roomRepository.getById(userId);
    }

    @Override
    public Room update(Long id, Room room) {
        Room roomEdit = roomRepository.findById(id).orElse(null);
        if (roomEdit == null) {
            return null;
        }

        return roomRepository.save(roomEdit);
    }

    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}
