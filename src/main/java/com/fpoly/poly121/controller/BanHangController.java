package com.fpoly.poly121.controller;

import com.fpoly.poly121.dto.SanPhamValue;
import com.fpoly.poly121.repository.KhachHangRepository;
import com.fpoly.poly121.repository.SanPhamReponsitory;
import com.fpoly.poly121.repository.TaiKhoanRepository;
import com.fpoly.poly121.service.SanPhamChiTietService;
import com.fpoly.poly121.service.impl.TrangChuServiceImpl;
import com.fpoly.poly121.utils.SecurityUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ban-hang")
@AllArgsConstructor
public class BanHangController {
    private final SanPhamChiTietService sanPhamChiTietService;
    private final TaiKhoanRepository taiKhoanRepository;
    private final TrangChuServiceImpl service;
    private final KhachHangRepository khachHangRepository;
    private final SanPhamReponsitory sanPhamReponsitory;

    @GetMapping
    public String view(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(required = false) String tenSp,
                       Model model) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<SanPhamValue> pageSp = sanPhamReponsitory.searchBanHang(tenSp, pageable);
        model.addAttribute("pageSp",pageSp);
        return "ban-hang";
    }

}
