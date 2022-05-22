package com.hotel.booking.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    @GetMapping(value = "/rooms")
    public String room() {
        return "atoli/elements/room";
    }

    @GetMapping(value = "/rooms/{id}")
    public String roomDetail() {
        return "atoli/elements/room-details";
    }
}
