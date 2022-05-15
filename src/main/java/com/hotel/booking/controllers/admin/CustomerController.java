package com.hotel.booking.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/admin/customers")
    public String getCustomers(Model model) {

        return "admin/elements/customers/index";
    }

    @GetMapping("/admin/elements/customers/create")
    public String createCustomer(Model model) {
        return "admin/elements/customers/create";
    }

    @GetMapping("/admin/elements/customers/edit")
    public String editCustomer(Model model) {
        return "admin/elements/customers/edit";
    }
}
