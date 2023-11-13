package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.SanPham;
import com.fpoly.poly121.model.SanPhamChiTiet;
import com.fpoly.poly121.repository.LoaiSanPhamRepository;
import com.fpoly.poly121.repository.TrangChuRepository;
import com.fpoly.poly121.service.TrangChuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrangChuServiceImpl implements TrangChuService {
    @Autowired
    TrangChuRepository trangChuRepository;

    @Override
    public List<SanPhamChiTiet> getAllNamMoiNhat() {
        return trangChuRepository.getAllNamMoiNhat();
    }

    @Override
    public List<SanPhamChiTiet> getAllNamNhieuNhat() {
        return null;
    }

    @Override
    public List<SanPhamChiTiet> getAllNuMoiNhat() {
        return trangChuRepository.getAllNuMoiNhat();
    }

    @Override
    public List<SanPhamChiTiet> getAllNuNhieuNhat() {
        return null;
    }

    @Override
    public SanPhamChiTiet findById(Long id) {
        return trangChuRepository.findById(id).get();
    }
}
