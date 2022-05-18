package com.hotel.booking.controllers.admin;

import com.hotel.booking.constants.JsonStructure;
import com.hotel.booking.entities.User;
import com.hotel.booking.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/admin/users")
    public String listUsers(@RequestParam(value = "current", required = false, defaultValue = JsonStructure.Pagination.CURRENT) int current,
                            @RequestParam(value = "pageSize", required = false, defaultValue = JsonStructure.Pagination.PAGE_SIZE) int pageSize,
                            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
                            Model model ) {

        model.addAttribute("searchText", searchText);
        model.addAttribute("users", userService.listUsers(current, pageSize, searchText));

        return "admin/elements/users/index";
    }

    @GetMapping(value = "/admin/users/create")
    public String showPageCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/elements/users/create";
    }

    @PostMapping(value = "/admin/users/create")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/elements/users/create";
        }
        userService.createUser(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping(value = "admin/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
