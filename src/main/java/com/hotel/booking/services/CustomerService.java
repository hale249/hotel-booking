package com.hotel.booking.services;

import com.hotel.booking.entities.Customer;
import com.hotel.booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<Customer> getUsers(Pageable page) {
        return customerRepository.findAll(page);
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
