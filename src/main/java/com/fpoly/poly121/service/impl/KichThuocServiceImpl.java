package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.KichThuoc;
import com.fpoly.poly121.repository.KichThuocRepository;
import com.fpoly.poly121.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KichThuocServiceImpl implements KichThuocService {

    @Autowired
    private KichThuocRepository repo;

    @Override
    public Page<KichThuoc> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 1);
        return repo.findAll(pageable);
    }

    @Override
    public List<KichThuoc> getList() {
        return repo.findAll();
    }

    @Override
    public void add(KichThuoc kichThuoc) {
        repo.save(kichThuoc);
    }

    @Override
    public void update(KichThuoc kichThuoc, Long id) {
        Optional<KichThuoc> kichThuocOptional = Optional.of(repo.findById(id).get());
        if (kichThuocOptional.isPresent()) {
            KichThuoc kichThuoc1 = kichThuocOptional.get();
            kichThuoc1.setTenKichThuoc(kichThuoc.getTenKichThuoc());
            kichThuoc1.setNguoiTao(kichThuoc.getNguoiTao());
            kichThuoc1.setNgayTao(kichThuoc.getNgayTao());
            kichThuoc1.setNguoiCapNhat(kichThuoc.getNguoiCapNhat());
            kichThuoc1.setNgayCapNhat(kichThuoc.getNgayCapNhat());
            kichThuoc1.setTrangThai(kichThuoc.getTrangThai());
            kichThuoc1.setDaXoa(kichThuoc.getDaXoa());
            repo.save(kichThuoc1);
        }
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public KichThuoc detail(long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<KichThuoc> search(String tenKichThuoc) {
        return repo.search(tenKichThuoc);
    }
}
