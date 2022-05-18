package com.hotel.booking.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {
    @GetMapping(value = "/services")
    public String blog() {
        return "atoli/elements/services";
    }

    @GetMapping(value = "/services/{id}")
    public String blogDetail() {
        return "atoli/elements/service-details";
    }
}
