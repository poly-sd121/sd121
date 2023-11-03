package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.KichThuoc;
import com.fpoly.poly121.repository.KichThuocReponsitory;
import com.fpoly.poly121.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KichThuocServiceImpl implements KichThuocService {
    @Autowired
    private KichThuocReponsitory kichThuocReponsitory;

    @Override
    public List<KichThuoc> getAll() {
        return kichThuocReponsitory.findAll();
    }
}
