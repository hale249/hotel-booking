package com.hotel.booking.services.impl;

import com.hotel.booking.entities.Service;
import com.hotel.booking.repositories.ServiceRepository;
import com.hotel.booking.services.ServiceHotelService;
import com.hotel.booking.utils.pagination.Paged;
import com.hotel.booking.utils.pagination.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

//@org.springframework.stereotype.Service
public class ServiceHotelServiceImpl implements ServiceHotelService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Paged<Service> getServices(int current, int pageSize, String searchText) {
        PageRequest request = PageRequest.of(current - 1, pageSize, Sort.by(Sort.Direction.ASC, "id"));
//        Page<Service> servicePage = serviceRepository.listServices(searchText, request);
//        return new Paged<>(servicePage, Paging.of(servicePage.getTotalPages(), current, pageSize));
        return null;
    }

    @Override
    public Service create(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.getById(id);
    }

    @Override
    public Service update(Long id, Service service) {
        Service serviceEdit = serviceRepository.findById(id).orElse(null);
        if (serviceEdit == null) {
            return null;
        }

        return serviceRepository.save(service);
    }

    @Override
    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }
}
