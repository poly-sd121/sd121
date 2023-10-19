package com.fpoly.poly121.controller;

import com.fpoly.poly121.repository.TaiKhoanRepository;
import com.fpoly.poly121.security.dto.TaiKhoan;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

        boolean isAdmin = false;
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            TaiKhoan taiKhoan = taiKhoanRepository.findByTenTaiKhoan(userDetails.getUsername());
            isAdmin = Objects.equals("ROLE_ADMIN",taiKhoan.getChucVu());
        } catch (Exception e) {
            log.info("truy cap chua login");
        }
        model.addAttribute("isAdmin", isAdmin);
        return "trang-chu";
    }
}
