package com.hotel.booking.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/admin/login")
    public String login(Model model) {
        return "/admin/elements/auth/login";
    }
}
