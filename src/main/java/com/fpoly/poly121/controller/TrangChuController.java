package com.fpoly.poly121.controller;

import com.fpoly.poly121.repository.TaiKhoanRepository;
import com.fpoly.poly121.utils.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/trang-chu")
@AllArgsConstructor
@Slf4j
public class TrangChuController {

    private final TaiKhoanRepository taiKhoanRepository;

    @GetMapping
    public String view(Model model) {
        model.addAttribute("isAdmin", SecurityUtil.checkIsAdmin(taiKhoanRepository));
        model.addAttribute("isStaff", SecurityUtil.checkIsStaff(taiKhoanRepository));
        model.addAttribute("isStaff", SecurityUtil.checkIsStaff(taiKhoanRepository));
        model.addAttribute("isUser", SecurityUtil.checkIsUser(taiKhoanRepository));
        model.addAttribute("isAuth", SecurityUtil.checkIsAuth(taiKhoanRepository));
        model.addAttribute("username", SecurityUtil.getUsernameLogin(taiKhoanRepository));
        return "trang-chu";
    }
}
