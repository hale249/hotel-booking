package com.hotel.booking.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/customers")
public class CustomerController {

    @GetMapping("/")
    public String index(Model model) {

        return "admin/elements/customers/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "admin/elements/customers/create";
    }

    @PostMapping("")
    public String store() {
        return "";
    }

    @GetMapping("/{id}")
    public String edit(Model model, @PathVariable String id) {
        return "admin/elements/customers/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable String id) {
        return "";
    }

    @GetMapping("/delete/{id}")
    public String destroy(@PathVariable String id) {
        return "";
    }
}
