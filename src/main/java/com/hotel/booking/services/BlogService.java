package com.hotel.booking.services;

import com.hotel.booking.entities.Blog;
import com.hotel.booking.entities.Customer;
import com.hotel.booking.utils.pagination.Paged;
import com.hotel.booking.validates.blog.BlogRequest;
import com.hotel.booking.validates.customer.CustomerRequest;

public interface BlogService {
    Paged<Blog> getBlogs(int current, int pageSize, String searchText);

    Blog create(Blog blog);

    Blog findById(Long id);

    Blog update(Long id, BlogRequest blog);

    void deleteById(Long id);
}
