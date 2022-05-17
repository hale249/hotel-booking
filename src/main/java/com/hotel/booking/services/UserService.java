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

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

//    public User createUser(RegistrationRequest registerRequest) {
//        User newUser = new User();
//        newUser.setEmail(registerRequest.getEmail());
//        newUser.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
//        newUser.setUsername(registerRequest.getUsername());
//        newUser.setFirstName(registerRequest.getFirstName());
//        newUser.setLastName(registerRequest.getLastName());
//        return newUser;
//    }

    public Page<User> getUsers(Pageable page) {
        return userRepository.findAll(page);
    }

    public Paged<User> listUsers(int current, int pageSize, String searchText) {
        PageRequest request = PageRequest.of(current - 1, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<User> userPage = userRepository.listUsers(searchText, request);
        return new Paged<>(userPage, Paging.of(userPage.getTotalPages(), current, pageSize));
    }
}
