package com.fpoly.poly121.controller;

import com.fpoly.poly121.model.LoaiSanPham;
import com.fpoly.poly121.service.impl.LoaiSanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/loai-san-pham")
public class LoaiSanPhamController {
    @Autowired
    private LoaiSanPhamServiceImpl service;

    @GetMapping("")
    public String getAll(@RequestParam(defaultValue = "0") Integer page, Model model) {
        Page<LoaiSanPham> page1 = service.findAll(page);
        List<LoaiSanPham> lstloaisp = page1.getContent();
        model.addAttribute("lstloaisp", lstloaisp);
        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        return "loai-san-pham/loai-san-pham";
    }

    /*@RequestMapping("")
    public String getAll(Model model, @RequestParam(defaultValue="0") int pageNumber) {
        Page<LoaiSanPham> Page = service.getByPage(pageNumber);
        model.addAttribute("page", Page);
        return "loai-san-pham";
    }*/

    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        //List<LoaiSanPham> value = Arrays.asList(LoaiSanPham.values());
        return "loai-san-pham/loai-san-pham";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("themloaisp") LoaiSanPham loaiSanPham) {
        model.addAttribute("loaisp", loaiSanPham);
        service.create(loaiSanPham);
        return "redirect:/loai-san-pham";
    }

    @GetMapping("update/{id}")
    public String update(ModelMap model, @PathVariable Long id) {
        LoaiSanPham loaisp = service.delete(id);
        model.addAttribute("updloaisp", loaisp);
        return "loai-san-pham/loai-san-pham-update";
    }

    @PostMapping("/update")
    public String update(Model modelMap, @ModelAttribute("updloaisp") LoaiSanPham loaisp) {
        service.update(loaisp);
        return "redirect:/loai-san-pham";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/loai-san-pham";
    }

    @GetMapping("/search")
    public String search(@RequestParam String tenLoai, Model model) {
        List<LoaiSanPham> lst = service.search(tenLoai);
        model.addAttribute("lstloaisp", lst);
        return "loai-san-pham/loai-san-pham";
    }
}
