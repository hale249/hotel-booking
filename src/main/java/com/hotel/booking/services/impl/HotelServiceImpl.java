package com.hotel.booking.services.impl;

import com.hotel.booking.entities.ServiceHotel;
import com.hotel.booking.repositories.ServiceRepository;
import com.hotel.booking.services.HotelService;
import com.hotel.booking.utils.pagination.Paged;
import com.hotel.booking.utils.pagination.Paging;
import com.hotel.booking.validates.service.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Paged<ServiceHotel> getServices(int current, int pageSize, String searchText) {
        PageRequest request = PageRequest.of(current - 1, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<ServiceHotel> servicePage = serviceRepository.listServices(searchText, request);
        return new Paged<>(servicePage, Paging.of(servicePage.getTotalPages(), current, pageSize));
    }

    @Override
    public ServiceHotel create(ServiceHotel service) {
        return serviceRepository.save(service);
    }

    @Override
    public ServiceHotel findById(Long id) {
        return serviceRepository.getById(id);
    }

    @Override
    public ServiceHotel update(Long id, ServiceRequest service, String image) {
        ServiceHotel serviceEdit = serviceRepository.findById(id).orElse(null);
        if (serviceEdit == null) {
            return null;
        }

        serviceEdit.setTitle(serviceEdit.getTitle());
        serviceEdit.setIcon(serviceEdit.getIcon());
        serviceEdit.setSortDescription(serviceEdit.getSortDescription());
        serviceEdit.setContent(serviceEdit.getContent());
        serviceEdit.setStatus(serviceEdit.isStatus());
        if (image != null) {
            serviceEdit.setImage(image);
        }

        return serviceRepository.save(serviceEdit);
    }

    @Override
    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }
}
