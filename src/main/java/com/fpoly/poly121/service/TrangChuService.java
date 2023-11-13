package com.fpoly.poly121.service;

import com.fpoly.poly121.model.SanPhamChiTiet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrangChuService {
    List<SanPhamChiTiet> getAllNamMoiNhat();
    List<SanPhamChiTiet> getAllNamNhieuNhat();
    List<SanPhamChiTiet> getAllNuMoiNhat();
    List<SanPhamChiTiet> getAllNuNhieuNhat();
    SanPhamChiTiet findById(Long id);
}
