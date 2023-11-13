package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.ThuongHieu;
import com.fpoly.poly121.repository.ThuongHieuRepository;
import com.fpoly.poly121.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    @Override
    public Page<ThuongHieu> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        return thuongHieuRepository.findAll(pageable);
    }
    public Page<ThuongHieu> phanTrangTimKiem(Integer pageNo, Integer size,String ten) {
        Pageable pageable = PageRequest.of(pageNo, size);

        return thuongHieuRepository.timKiem(ten,pageable);
    }
    @Override
    public List<ThuongHieu> timKiem(String ten) {
//        return thuongHieuRepository.timKiem(ten);
        return null;
    }

    @Override
    public void add(ThuongHieu thuongHieu) {
        thuongHieu.setNgayTao(LocalDate.now());
        thuongHieu.setDaXoa(false);
       thuongHieuRepository.save(thuongHieu);

    }
    @Override
    public void  update(ThuongHieu thuongHieu){
        thuongHieu.setNgayCapNhat(LocalDate.now());
        thuongHieuRepository.save(thuongHieu);
    }

    @Override
    public void  delete(Long id){

        thuongHieuRepository.deleteById(id);
    }
    @Override
    public  ThuongHieu getById(Long id){
        return  thuongHieuRepository.findById(id).orElse(null);
    }
    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepository.findAll();
    }

}
