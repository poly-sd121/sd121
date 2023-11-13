package com.fpoly.poly121.controller;

import com.fpoly.poly121.model.LoaiSanPham;
import com.fpoly.poly121.model.SanPhamChiTiet;
import com.fpoly.poly121.repository.KhachHangRepository;
import com.fpoly.poly121.repository.TaiKhoanRepository;
import com.fpoly.poly121.service.impl.TrangChuServiceImpl;
import com.fpoly.poly121.utils.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/trang-chu")
@AllArgsConstructor
@Slf4j
public class TrangChuController {

    private final TaiKhoanRepository taiKhoanRepository;
    private final TrangChuServiceImpl service;
    private final KhachHangRepository khachHangRepository;

    @GetMapping
    public String view(Model model) {
        List<SanPhamChiTiet> namMN = service.getAllNamMoiNhat();
        List<SanPhamChiTiet> nuMN = service.getAllNuMoiNhat();
        model.addAttribute("isAdmin", SecurityUtil.checkIsAdmin(taiKhoanRepository));
        model.addAttribute("isStaff", SecurityUtil.checkIsStaff(taiKhoanRepository));
        model.addAttribute("isStaff", SecurityUtil.checkIsStaff(taiKhoanRepository));
        model.addAttribute("isUser", SecurityUtil.checkIsUser(taiKhoanRepository));
        model.addAttribute("isAuth", SecurityUtil.checkIsAuth(taiKhoanRepository));
        model.addAttribute("spNamMN", namMN);
        model.addAttribute("spNuMN", nuMN);
        model.addAttribute("username", SecurityUtil.getUsernameLogin());
        model.addAttribute("idKh", SecurityUtil.getIdKhachHangLogin(khachHangRepository, taiKhoanRepository));
        return "trang-chu";
    }

    @GetMapping("chi-tiet/{id}")
    public String detail(ModelMap model, @PathVariable Long id) {
        SanPhamChiTiet spdetail = service.findById(id);
        model.addAttribute("spdetail", spdetail);
        return "san_pham_chi_tiet/thongTinSp";
    }
}
