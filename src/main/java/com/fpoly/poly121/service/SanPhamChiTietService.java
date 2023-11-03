package com.fpoly.poly121.service;


import com.fpoly.poly121.model.SanPhamChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SanPhamChiTietService {
    Page<SanPhamChiTiet> getAll(Integer page);
    void add(SanPhamChiTiet sanPhamChiTiet);
    void update(SanPhamChiTiet sanPhamChiTiet);
    void delete(Long id);
    SanPhamChiTiet detail(Long id);
//    List<SanPhamChiTiet> search ( String tenSanPhamChiTiet);
}
