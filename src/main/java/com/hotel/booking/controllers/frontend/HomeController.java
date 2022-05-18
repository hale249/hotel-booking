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

    @GetMapping(value="/blog")
    public String blog(Model model) {
        return "frontend/index";
    }

    @GetMapping(value="/zoom")
    public String zoom(Model model) {
        return "frontend/index";
    }
}
