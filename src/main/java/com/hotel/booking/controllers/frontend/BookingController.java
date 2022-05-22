package com.hotel.booking.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
    @GetMapping(value = "/booking")
    public String pageBooking() {
        return "atoli/elements/book";
    }
}
