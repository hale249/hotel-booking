package com.hotel.booking.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProfileController {
    @GetMapping("/profile")
    public String showFormProfile() {
        return "";
    }

    @GetMapping("/profile")
    public String profile() {
        return "";
    }
}
