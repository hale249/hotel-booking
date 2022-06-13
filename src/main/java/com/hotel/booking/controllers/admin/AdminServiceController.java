package com.hotel.booking.controllers.admin;

import com.hotel.booking.constants.JsonStructure;
import com.hotel.booking.entities.ServiceHotel;
import com.hotel.booking.entities.User;
import com.hotel.booking.services.HotelService;
import com.hotel.booking.services.StorageService;
import com.hotel.booking.validates.service.ServiceRequest;
import com.hotel.booking.validates.user.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Controller
@RequestMapping("admin/services")
public class AdminServiceController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private StorageService storageService;

    @GetMapping("")
    public String index(@RequestParam(value = "current", required = false, defaultValue = JsonStructure.Pagination.CURRENT) int current,
                        @RequestParam(value = "pageSize", required = false, defaultValue = JsonStructure.Pagination.PAGE_SIZE) int pageSize,
                        @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText, Model model) {

        model.addAttribute("searchText", searchText);
        model.addAttribute("services", hotelService.getServices(current, pageSize, searchText));

        return "admin/elements/service/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("service", new ServiceHotel());

        return "admin/elements/service/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("service") ServiceRequest request,
                        @RequestParam @NotEmpty(message = "File không được để trông") MultipartFile image,
                        BindingResult result,
                        RedirectAttributes redirectAttributes) throws Exception {
        try {
            if (result.hasErrors()) {
                redirectAttributes.addFlashAttribute("error", "Dữ liệu không hợp lệ");
                return "admin/elements/service/create";
            }

            String fileName = storageService.storeFile(image);
            ServiceHotel data = new ServiceHotel();
            data.setTitle(request.getTitle());
            data.setIcon(request.getIcon());
            data.setSortDescription(request.getSortDescription());
            data.setContent(request.getContent());
            data.setStatus(request.isStatus());
            if (fileName != null) {
                fileName = "uploads/" + fileName;
            }
            data.setImage(fileName);
            ServiceHotel newService = hotelService.create(data);
            if (newService == null) {
                redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
                return "admin/elements/service/edit";
            }

            redirectAttributes.addFlashAttribute("success", "Tạo người dùng thành công");

            return "redirect:/admin/services";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
            return "admin/elements/service/create";
        }
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        ServiceHotel service = hotelService.findById(id);
        if (service == null) {
            return "admin/elements/errors/404";
        }
        model.addAttribute("service", service);

        return "admin/elements/service/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") long id, @Valid @ModelAttribute("service") ServiceRequest request,
                         @RequestParam MultipartFile image,
                         BindingResult result, RedirectAttributes redirectAttributes) throws Exception {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Dữ liệu không hợp lệ");

            return "admin/elements/service/edit";
        }

        String fileName = null;
        if (image != null) {
            fileName = storageService.storeFile(image);
            if (fileName != null) {
                fileName = "uploads/" + fileName;
            }
        }

        ServiceHotel updateService = hotelService.update(id, request, fileName);
        if (updateService == null) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
            return "admin/elements/service/edit";
        }

        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");

        return "redirect:/admin/service";
    }

    @GetMapping("/delete/{id}")
    public String destroy(@PathVariable Long id,  RedirectAttributes redirectAttributes) {
         ServiceHotel service = hotelService.findById(id);
        if (service == null) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
        }

        hotelService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa dịch vụ thành công");

        return "redirect:/admin/services";
    }
}
