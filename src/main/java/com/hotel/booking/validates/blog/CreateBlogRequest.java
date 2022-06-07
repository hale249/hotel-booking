package com.hotel.booking.validates.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateBlogRequest {
    @NotEmpty(message = "Tiêu đề không được để trống")
    private String title;

    @NotEmpty(message = "Tiêu đề phụ không được để trống")
    private String subTitle;

    private boolean status;

    @NotEmpty(message = "Số điện thoại không được để trống")
    private String description;
}
