package com.hotel.booking.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/blog")
public class BlogController {
    @GetMapping("")
    public String index() {
        return "";
    }

    @GetMapping("/create")
    public String create() {
        return "";
    }

    @PostMapping("/")
    public String store() {
        return "";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable String id) {
        return "";
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
