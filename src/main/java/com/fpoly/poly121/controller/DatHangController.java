package com.fpoly.poly121.controller;

import com.fpoly.poly121.repository.KhachHangRepository;
import com.fpoly.poly121.repository.TaiKhoanRepository;
import com.fpoly.poly121.utils.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dat-hang")
@AllArgsConstructor
@Slf4j
public class DatHangController {
    private final TaiKhoanRepository taiKhoanRepository;
    private final KhachHangRepository khachHangRepository;
    //            ("/checkout")
    @GetMapping
    public String checkout(Model model){
        model.addAttribute("isAdmin", SecurityUtil.checkIsAdmin(taiKhoanRepository));
        model.addAttribute("isStaff", SecurityUtil.checkIsStaff(taiKhoanRepository));
        model.addAttribute("isStaff", SecurityUtil.checkIsStaff(taiKhoanRepository));
        model.addAttribute("isUser", SecurityUtil.checkIsUser(taiKhoanRepository));
        model.addAttribute("isAuth", SecurityUtil.checkIsAuth(taiKhoanRepository));
        model.addAttribute("username", SecurityUtil.getUsernameLogin());
        model.addAttribute("idKh", SecurityUtil.getIdKhachHangLogin(khachHangRepository, taiKhoanRepository));
        model.addAttribute("test",2);
        return "trang-chu";
    }
}
