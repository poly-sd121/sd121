package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.LoaiSanPham;
import com.fpoly.poly121.repository.LoaiSanPhamReponsitory;
import com.fpoly.poly121.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {
    @Autowired
    private LoaiSanPhamReponsitory loaiSanPhamReponsitory;

    @Override
    public List<LoaiSanPham> getAll() {
        return loaiSanPhamReponsitory.findAll();
    }
}
