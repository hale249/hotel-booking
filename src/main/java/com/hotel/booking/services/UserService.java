package com.hotel.booking.services;

import com.hotel.booking.entities.User;
import com.hotel.booking.repositories.UserRepository;
import com.hotel.booking.utils.pagination.Paged;
import com.hotel.booking.utils.pagination.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    public Optional<User> findByUsername(String username);

    public Boolean existsByEmail(String email);

    public Boolean existsByUsername(String username);

    public User createUser(User user);

    public Page<User> getUsers(Pageable page);

    public Paged<User> listUsers(int current, int pageSize, String searchText);

    public void deleteUserById(Long userId);
}