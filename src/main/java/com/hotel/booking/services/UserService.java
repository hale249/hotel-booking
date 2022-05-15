package com.hotel.booking.services;

import com.hotel.booking.entities.User;
import com.hotel.booking.entities.payload.RegistrationRequest;
import com.hotel.booking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public User createUser(RegistrationRequest registerRequest) {
        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
        newUser.setUsername(registerRequest.getUsername());
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        return newUser;
    }

    public Page<User> getUsers(Pageable page) {
        return userRepository.findAll(page);
    }
}
