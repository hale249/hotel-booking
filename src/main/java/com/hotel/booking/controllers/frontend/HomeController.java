package com.hotel.booking.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value="/")
    public String home(Model model) {
        return "frontend/elements/home";
    }

    @GetMapping(value="/404")
    public String notFound(Model model) {
        return "atoli/elements/404";
    }

    @GetMapping(value="/about")
    public String about(Model model) {
        return "atoli/elements/about";
    }

    @GetMapping(value="/contact")
    public String contact(Model model) {
        return "atoli/elements/contact";
    }
}
