package com.hotel.booking.controllers.admin;

import com.hotel.booking.constants.JsonStructure;
import com.hotel.booking.entities.Room;
import com.hotel.booking.entities.User;
import com.hotel.booking.services.RoomService;
import com.hotel.booking.services.impl.UserServiceImpl;
import com.hotel.booking.validates.room.RoomRequest;
import com.hotel.booking.validates.user.CreateUserRequest;
import com.hotel.booking.validates.user.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/rooms")
public class AdminRoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping(value = "")
    public String index(@RequestParam(value = "current", required = false, defaultValue = JsonStructure.Pagination.CURRENT) int current,
                        @RequestParam(value = "pageSize", required = false, defaultValue = JsonStructure.Pagination.PAGE_SIZE) int pageSize,
                        @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText, Model model) {

        model.addAttribute("searchText", searchText);
        model.addAttribute("rooms", roomService.listRooms(current, pageSize, searchText));

        return "admin/elements/room/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("room", new Room());
        return "admin/elements/room/create";
    }

    @PostMapping(value = "/create")
    public String store(@Valid @ModelAttribute("room") RoomRequest request, BindingResult result,
                        RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Dữ liệu không hợp lệ");
            return "admin/elements/room/create";
        }

//        Room newRoom = roomService.create(request);
//        if (newRoom == null) {
//            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
//            return "admin/elements/users/edit";
//        }

        redirectAttributes.addFlashAttribute("success", "Tạo người dùng thành công");

        return "redirect:/admin/users";
    }
//
//    @GetMapping("{id}")
//    public String edit(@PathVariable("id") long id, Model model) {
//        User user = roomService.findById(id);
//        if (user == null) {
//            return "admin/elements/errors/404";
//        }
//        model.addAttribute("user", user);
//
//        return "admin/elements/users/edit";
//    }
//
//    @PostMapping("{id}")
//    public String update(@PathVariable("id") long id, @Valid @ModelAttribute("user") UpdateUserRequest user,
//                                BindingResult result, RedirectAttributes redirectAttributes) throws Exception {
//        if (result.hasErrors()) {
//            redirectAttributes.addFlashAttribute("error", "Dữ liệu không hợp lệ");
//
//            return "admin/elements/users/edit";
//        }
//
//        User updateUser = userService.update(id, user);
//        if (updateUser == null) {
//            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
//            return "admin/elements/users/edit";
//        }
//
//        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
//
//        return "redirect:/admin/users";
//    }
//
//    @GetMapping(value = "/delete/{id}")
//    public String destroy(@PathVariable Long id,  RedirectAttributes redirectAttributes) {
//        User user = userService.findById(id);
//        if (user == null) {
//            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
//        }
//
//        userService.deleteUserById(id);
//        redirectAttributes.addFlashAttribute("success", "Xóa người dùng thành công");
//
//        return "redirect:/admin/users";
//    }
}
