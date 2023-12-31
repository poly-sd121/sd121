package com.fpoly.poly121.service;


import com.fpoly.poly121.model.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SanPhamChiTietService {
    Page<SanPhamChiTiet> getAll(Integer page);
    void add(SanPhamChiTiet sanPhamChiTiet , MultipartFile file);
    void update(SanPhamChiTiet sanPhamChiTiet );
    void delete(Long id);
    void xoaAnh(Long id);
    SanPhamChiTiet detail(Long id);
    List<SanPhamChiTiet> search(String keyword);
    List<SanPhamChiTiet> search2(String keyword2 , String keyword3);
    List<SanPhamChiTiet> search3(String sl);
}
