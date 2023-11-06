package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.SanPhamChiTiet;
import com.fpoly.poly121.repository.SanPhamChiTietReponsitory;
import com.fpoly.poly121.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {
    @Autowired
    private SanPhamChiTietReponsitory sanPhamChiTietRepository;


    @Override
    public Page<SanPhamChiTiet> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page,5);
        return sanPhamChiTietRepository.findAll(pageable);
    }

    @Override
    public void add(SanPhamChiTiet sanPhamChiTiet) {
        sanPhamChiTietRepository.save(sanPhamChiTiet);

    }

    @Override
    public void update(SanPhamChiTiet sanPhamChiTiet) {
        sanPhamChiTietRepository.save(sanPhamChiTiet);

    }

    @Override
    public void delete(Long id) {
        sanPhamChiTietRepository.deleteById(id);

    }

    @Override
    public SanPhamChiTiet detail(Long id) {
        return sanPhamChiTietRepository.getById(id);
    }

    @Override
    public List<SanPhamChiTiet> search(String keyword) {
        return sanPhamChiTietRepository.search(keyword);
    }

    @Override
    public List<SanPhamChiTiet> search2(String keyword2, String keyword3) {
        return sanPhamChiTietRepository.search2(keyword2,keyword3);
    }

    @Override
    public List<SanPhamChiTiet> search3(String sl) {
        return sanPhamChiTietRepository.search3();
    }


}
