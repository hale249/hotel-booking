package com.hotel.booking.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/admin/users")
    public String listUsers(Model model) {

        return "admin/layouts/app";
    }
}
