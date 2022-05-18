package com.hotel.booking.dto;

import javax.validation.constraints.NotNull;

public class User {
    @NotNull
    private  String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
