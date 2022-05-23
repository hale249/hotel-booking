package com.hotel.booking.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServiceController {
    @GetMapping(value = "")
    public String blog() {
        return "atoli/elements/services";
    }

    @GetMapping(value = "/{id}")
    public String detail(@PathVariable String id) {
        return "atoli/elements/service-details";
    }
}
