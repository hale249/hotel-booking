package com.hotel.booking.validates.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequest {
    @NotEmpty(message = "Tiêu đề không được để trống")
    private String title;

    @NotEmpty(message = "Tiêu đề phụ không được để trống")
    private String subTitle;

    private String image;

    private boolean status;

    @NotEmpty(message = "Số điện thoại không được để trống")
    private String description;
}
