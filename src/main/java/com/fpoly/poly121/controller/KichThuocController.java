package com.fpoly.poly121.controller;

import com.fpoly.poly121.model.KichThuoc;
import com.fpoly.poly121.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocService ser;
    List<KichThuoc> listkt;

    @GetMapping("/hien-thi")
    public String getAll(@RequestParam(defaultValue = "0") Integer page, Model model) {
        Page<KichThuoc> page1 = ser.getAll(page);
        listkt = page1.getContent();
        model.addAttribute("listkt", listkt);
        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        return "kich-thuoc/hien-thi";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @RequestParam("tenKichThuoc") String tenKichThuoc,
                       @RequestParam("nguoiTao") String nguoiTao,
                       @RequestParam("ngayTao") LocalDate ngayTao,
                       @RequestParam("nguoiCapNhat") String nguoiCapNhat,
                       @RequestParam("ngayCapNhat") LocalDate ngayCapNhat,
                       @RequestParam("trangThai") Integer trangThai,
                       @RequestParam("daXoa") boolean daXoa) {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setTenKichThuoc(tenKichThuoc);
        kichThuoc.setNguoiTao(nguoiTao);
        kichThuoc.setNgayTao(ngayTao);
        kichThuoc.setNguoiCapNhat(nguoiCapNhat);
        kichThuoc.setNgayCapNhat(ngayCapNhat);
        kichThuoc.setTrangThai(trangThai);
        kichThuoc.setDaXoa(daXoa);
        ser.add(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") Long id) {
        KichThuoc kichThuoc = ser.detail(id);
        model.addAttribute("dc", kichThuoc);

        return "kich-thuoc/update";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        ser.delete(id);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") Long id,
                         @RequestParam("tenKichThuoc") String tenKichThuoc,
                         @RequestParam("nguoiTao") String nguoiTao,
                         @RequestParam("ngayTao") LocalDate ngayTao,
                         @RequestParam("nguoiCapNhat") String nguoiCapNhat,
                         @RequestParam("ngayCapNhat") LocalDate ngayCapNhat,
                         @RequestParam("trangThai") Integer trangThai,
                         @RequestParam("daXoa") boolean daXoa) {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setTenKichThuoc(tenKichThuoc);
        kichThuoc.setNguoiTao(nguoiTao);
        kichThuoc.setNgayTao(ngayTao);
        kichThuoc.setNguoiCapNhat(nguoiCapNhat);
        kichThuoc.setNgayCapNhat(ngayCapNhat);
        kichThuoc.setTrangThai(trangThai);
        kichThuoc.setDaXoa(daXoa);
        ser.update(kichThuoc, id);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam String tenKichThuoc, Model model) {
        listkt = ser.search(tenKichThuoc);
        model.addAttribute("listkt", listkt);
        return "kich-thuoc/hien-thi";
    }
}

