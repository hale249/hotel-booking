package com.hotel.booking.controllers.admin;

import com.hotel.booking.constants.JsonStructure;
import com.hotel.booking.entities.Blog;
import com.hotel.booking.entities.User;
import com.hotel.booking.services.BlogService;
import com.hotel.booking.services.FilesStorageService;
import com.hotel.booking.validates.blog.BlogRequest;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.aspectj.bridge.IMessage;
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
@RequestMapping("admin/blog")
public class AdminBlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private FilesStorageService filesStorageService;

    @GetMapping("")
    public String index(@RequestParam(value = "current", required = false, defaultValue = JsonStructure.Pagination.CURRENT) int current,
                        @RequestParam(value = "pageSize", required = false, defaultValue = JsonStructure.Pagination.PAGE_SIZE) int pageSize,
                        @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText, Model model) {

        model.addAttribute("searchText", searchText);
        model.addAttribute("blogs", blogService.getBlogs(current, pageSize, searchText));

        return "admin/elements/blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "admin/elements/blog/create";
    }

    @PostMapping("/")
    public String store(@RequestParam @NotEmpty(message = "Tiêu đề không được để trống") String title,
                        @RequestParam @NotEmpty(message = "Tiêu đề phụ không được để trông") String subTitle,
                        @RequestParam @NotEmpty(message = "File không được để trông") MultipartFile image,
                        @RequestParam @NotEmpty(message = "Nội dung không được để trông") String description,
                        @RequestParam Boolean status,
                        BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Dữ liệu không hợp lệ");
            return "admin/elements/blog/create";
        }

        String fileName = "uploads/" + image.getOriginalFilename();
        Blog newBlog = new Blog();
        newBlog.setTitle(title);
        newBlog.setSubTitle(subTitle);
        newBlog.setDescription(description);
        newBlog.setImage(fileName);
        newBlog.setStatus(status);

        Blog saveBlog = blogService.create(newBlog);
        if (saveBlog == null) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
            return "admin/elements/blog/edit";
        }

        redirectAttributes.addFlashAttribute("success", "Tạo người dùng thành công");
        return "redirect:/admin/blog";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return "admin/elements/errors/404";
        }

        model.addAttribute("blog", blog);
        return "admin/elements/blog/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") long id, @Valid @ModelAttribute("blog") BlogRequest user,
                         BindingResult result, RedirectAttributes redirectAttributes) throws Exception {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Dữ liệu không hợp lệ");

            return "admin/elements/blog/edit";
        }

        Blog updateBlog = blogService.update(id, user);
        if (updateBlog == null) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
            return "admin/elements/blog/edit";
        }

        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");

        return "redirect:/admin/blog";
    }

    @GetMapping("/delete/{id}")
    public String destroy(@PathVariable Long id,  RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra");
        }

        blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa người dùng thành công");
        return "redirect:/admin/blog";
    }
}
