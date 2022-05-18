package com.hotel.booking.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping(value = "/blog")
    public String blog() {
        return "atoli/elements/blog";
    }

    @GetMapping(value = "/blog/{id}")
    public String blogDetail() {
        return "atoli/elements/blog-details";
    }
}
