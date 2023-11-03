package com.fpoly.poly121.service.impl;


import com.fpoly.poly121.model.ThuongHieu;
import com.fpoly.poly121.repository.ThuongHieuReponsitory;
import com.fpoly.poly121.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    private ThuongHieuReponsitory thuongHieuReponsitory;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuReponsitory.findAll();
    }
}
