package com.fpoly.poly121.service;

import com.fpoly.poly121.model.LoaiSanPham;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoaiSanPhamService {
    Page<LoaiSanPham> findAll(Integer page);
    LoaiSanPham findById(Long id);
    List<LoaiSanPham> findLoaiSanPhamBy(Boolean daXoa);
    LoaiSanPham create(LoaiSanPham loaisanpham);
    LoaiSanPham update(LoaiSanPham loaisanpham);
    LoaiSanPham delete(Long id);
    Page<LoaiSanPham> getByPage(int pageNumber);
    List<LoaiSanPham> search(String tenLoai);
    List<LoaiSanPham> getAll();
}