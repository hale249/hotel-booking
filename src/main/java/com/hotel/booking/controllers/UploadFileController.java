package com.hotel.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;

@Controller
public class UploadFileController {
    private ServletContext app;

    @GetMapping("/upload")
    public String uploadFile() {
        return  "";
    }
}
