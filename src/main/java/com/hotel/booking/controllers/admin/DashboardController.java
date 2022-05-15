package com.hotel.booking.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/admin")
    public String dashboard(Model model) {

        return "admin/elements/dashboard/index";
    }
}
