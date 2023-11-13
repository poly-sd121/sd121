package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.LoaiSanPham;
import com.fpoly.poly121.repository.LoaiSanPhamRepository;
import com.fpoly.poly121.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {
    LocalDate hienTai = LocalDate.now();
    @Autowired
    LoaiSanPhamRepository loaiSanPhamRepository;

    @Override
    public LoaiSanPham findById(Long id) {
        return loaiSanPhamRepository.findById(id).get();
    }

    @Override
    public List<LoaiSanPham> findLoaiSanPhamBy(Boolean daXoa) {
        //return loaiSanPhamRepository.findLoaiSanPhamBy(daXoa);
        return null;
        //tạm để trống
    }

    @Override
    public LoaiSanPham create(LoaiSanPham loaiSanPham) {
        loaiSanPham.setNguoiTao(null);
        loaiSanPham.setNgayTao(hienTai);
        loaiSanPham.setNguoiCapNhat(null);
        loaiSanPham.setNgayCapNhat(hienTai);
        loaiSanPham.setTrangThai(0);
        loaiSanPham.setDaXoa(false);
        return loaiSanPhamRepository.save(loaiSanPham);
    }

    @Override
    public LoaiSanPham update(LoaiSanPham loaiSanPham) {
        Long id = loaiSanPham.getId();
        LocalDate updTime = loaiSanPham.getNgayTao();
        boolean tontai = loaiSanPhamRepository.existsById(id);
        if(tontai){
            loaiSanPham.setNguoiTao(null);
            loaiSanPham.setNgayTao(updTime);
            loaiSanPham.setNguoiCapNhat(null);
            loaiSanPham.setNgayCapNhat(hienTai);
            loaiSanPham.setDaXoa(false);
            return loaiSanPhamRepository.save(loaiSanPham);
        }
        return null;
    }

    @Override
    public LoaiSanPham delete(Long id) {
        if(id != null) {
            Optional<LoaiSanPham> p = loaiSanPhamRepository.findById(id);
            if(p.isPresent()) {
                LoaiSanPham loaiSanPham = p.get();
                loaiSanPham.setDaXoa(true);
                return loaiSanPhamRepository.save(loaiSanPham);
            }
        }
        return null;
    }

    @Override
    public Page<LoaiSanPham> getByPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 5);
        Page<LoaiSanPham> page = loaiSanPhamRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<LoaiSanPham> search(String tenLoai) {
        return loaiSanPhamRepository.search(tenLoai);
    }

    @Override
    public Page<LoaiSanPham> findAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return loaiSanPhamRepository.findAll(pageable);
    }

    @Override
    public List<LoaiSanPham> getAll() {
        return loaiSanPhamRepository.getLoaiSanPham();
    }
}