package com.fpoly.poly121.controller;



import com.fpoly.poly121.model.SanPham;
import com.fpoly.poly121.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    List<SanPham> listSp;

    @GetMapping("index")
    public String getAll(@RequestParam(defaultValue = "0") Integer page, Model model) {
        Page<SanPham> page1 = sanPhamService.getAll(page);
        listSp = page1.getContent();
        model.addAttribute("listSp", listSp);
        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        return "san_pham/index";
    }

    @PostMapping("add")
    public String add(@Validated @ModelAttribute SanPham sanPham, BindingResult bindingResult ,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", "Khong de trong !");
            return "san_pham/add";
        } else {
            sanPhamService.add(sanPham);
            return "redirect:/san-pham/index";
        }
    }

    @PostMapping("update/{id}")
    public String update( @PathVariable Long id, @Valid @ModelAttribute SanPham sanPham ,BindingResult bindingResult ,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors","Khong de trong !");
            SanPham sanPham1 = sanPhamService.detail(id);
            model.addAttribute("sp", sanPham1);
            return "san_pham/update";
        } else {
            sanPhamService.update(sanPham);
            return "redirect:/san-pham/index";
        }

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("listId", "Update");
        sanPhamService.delete(id);
        return "redirect:/san-pham/index";
    }


    @GetMapping("form-add")
    public String formAdd() {
        return "san_pham/add";
    }
    @GetMapping("form-update/{id}")
    public String formUpdate( @PathVariable Long id , Model model) {
        SanPham sanPham = sanPhamService.detail(id);
        model.addAttribute("sp", sanPham);
        return "san_pham/update";
    }

    @GetMapping("search")
    public String search(@RequestParam String tenSanPham, Model model) {
        listSp = sanPhamService.search(tenSanPham);
        model.addAttribute("listSp", listSp);
        return "san_pham/index";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0") Integer page, @PathVariable Long id, Model model) {
        Page<SanPham> page1 = sanPhamService.getAll(page);
        listSp = page1.getContent();
        model.addAttribute("listSp", listSp);
        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        SanPham sanPham = sanPhamService.detail(id);
        model.addAttribute("sp", sanPham);
        return "san_pham/index";
    }
}
