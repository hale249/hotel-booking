package com.hotel.booking.dto;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String address;
    private String username;
    private String email;
    private String password;
    private Boolean active;
    private String avatar;
    private Long birthday;
}
