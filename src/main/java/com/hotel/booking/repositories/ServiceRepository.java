package com.hotel.booking.repositories;

import com.hotel.booking.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
    Page<Service> listServices(String searchText, Pageable pageable);
}
