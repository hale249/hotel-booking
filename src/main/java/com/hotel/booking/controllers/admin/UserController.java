package com.hotel.booking.controllers.admin;

import com.hotel.booking.entities.User;
import com.hotel.booking.services.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    @GetMapping("/admin/users")
    public String listUsers(@Param(value = "current") int current,
                            @Param(value = "pageSize") int pageSize,
                            @Param(value = "searchText") String searchText, Model model) {

        model.addAttribute("users", userService.listUsers(current, pageSize, searchText));
        return "admin/elements/users/index";
    }

    @GetMapping("/admin/users/create")
    public String showPageCreateUser(User user) {

        return "admin/elements/users/create";
    }

    @PostMapping("/admin/users/create")
    public String createUser(Model model) {

        return "admin/elements/users/create";
    }
}
