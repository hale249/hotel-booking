package com.hotel.booking.services;

import com.hotel.booking.entities.Service;
import com.hotel.booking.utils.pagination.Paged;

public interface ServiceHotelService {
    Paged<Service> getServices(int current, int pageSize, String searchText);

    Service create(Service service);

    Service findById(Long id);

    Service update(Long id, Service service);

    void deleteById(Long id);
}
