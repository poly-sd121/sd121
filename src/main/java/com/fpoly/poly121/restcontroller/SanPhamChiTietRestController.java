package com.fpoly.poly121.restcontroller;

import com.fpoly.poly121.dto.sanphamchitiet.SanPhamChiTietDto;
import com.fpoly.poly121.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/sanphamchitiet")
public class SanPhamChiTietRestController {

    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;

    @GetMapping("/{id}")
    public SanPhamChiTietDto getOne(@PathVariable("id") Long id){
        return sanPhamChiTietService.findById(id);
    }
}
