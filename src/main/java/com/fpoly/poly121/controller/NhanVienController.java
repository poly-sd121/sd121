package com.fpoly.poly121.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {

    @GetMapping
    public String view() {
        return "user-page";
    }
}
