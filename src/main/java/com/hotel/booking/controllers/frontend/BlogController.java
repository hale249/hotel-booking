package com.hotel.booking.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @GetMapping(value = "")
    public String blog() {
        return "atoli/elements/blog";
    }

    @GetMapping(value = "/{id}")
    public String blogDetail() {
        return "atoli/elements/blog-details";
    }
}
