package com.hotel.booking.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @GetMapping(value = "")
    public String room() {
        return "atoli/elements/room";
    }

    @GetMapping(value = "/{id}")
    public String roomDetail() {
        return "atoli/elements/room-details";
    }
}
