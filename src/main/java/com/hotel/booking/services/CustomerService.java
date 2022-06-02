package com.hotel.booking.services;

import com.hotel.booking.entities.Blog;
import com.hotel.booking.entities.Customer;
import com.hotel.booking.utils.pagination.Paged;
import com.hotel.booking.validates.customer.CustomerRequest;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Paged<Customer> getCustomers(int current, int pageSize, String searchText);

    Customer create(CustomerRequest customer);

    Customer findById(Long customerId);

    Customer update(Long id, CustomerRequest customer);

    void deleteById(Long customerId);
}
