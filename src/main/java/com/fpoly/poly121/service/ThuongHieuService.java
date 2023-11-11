package com.fpoly.poly121.service;

import com.fpoly.poly121.model.ThuongHieu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ThuongHieuService {

    Page<ThuongHieu> phanTrang(Integer pageNo, Integer i);

    void add(ThuongHieu thuongHieu);

        List<ThuongHieu> timKiem(String ten);
    Page<ThuongHieu> phanTrangTimKiem(Integer pageNo, Integer size,String ten);

    ThuongHieu getById(Long id);

    void update(ThuongHieu thuongHieu);

    void delete(Long id);
    List<ThuongHieu> getAll();
}
