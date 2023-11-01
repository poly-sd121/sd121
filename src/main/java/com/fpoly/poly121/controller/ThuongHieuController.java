package com.fpoly.poly121.controller;

import com.fpoly.poly121.model.ThuongHieu;
import com.fpoly.poly121.service.ThuongHieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/thuong-hieu")
public class ThuongHieuController {
    @Autowired
    private ThuongHieuService thuongHieuService;
    private Long idUpdate;

    @GetMapping("/hien-thi")

    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer pageNo, Model model) {
        model.addAttribute("listThuongHieu", thuongHieuService.phanTrang(pageNo, 5));
        model.addAttribute("thuongHieu", new ThuongHieu());
        return "thuong-hieu/hien-thi";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("thuongHieu") ThuongHieu thuongHieu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listThuongHieu", thuongHieuService.phanTrang(0, 5));
            return "thuong-hieu/hien-thi";
        }
        thuongHieuService.add(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }

    @GetMapping("/tim-kiem")
    public String timKiem(@RequestParam(defaultValue = "0", name = "page") Integer pageNo,@RequestParam("ten") String ten, Model model) {
        model.addAttribute("listThuongHieuTK", thuongHieuService.phanTrangTimKiem(pageNo,5,ten));
        System.out.println("kkkkk: "+thuongHieuService.phanTrangTimKiem(pageNo,5,ten));
        model.addAttribute("thuongHieu", new ThuongHieu());
        model.addAttribute("tentk",ten);
        return "thuong-hieu/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable("id") Long id, Model model) {
        ThuongHieu thuongHieu = thuongHieuService.getById(id);
        idUpdate = thuongHieu.getId();
        model.addAttribute("thuongHieu", thuongHieu);
        return "thuong-hieu/view-update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
      thuongHieuService.delete(id);
        return "redirect:/thuong-hieu/hien-thi";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("thuongHieu") ThuongHieu thuongHieu) {
        thuongHieuService.update(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }
}
