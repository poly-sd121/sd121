package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.MauSac;
import com.fpoly.poly121.repository.MauSacReponsitory;
import com.fpoly.poly121.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacReponsitory mauSacReponsitory;

    @Override
    public List<MauSac> getAll() {
        return mauSacReponsitory.findAll();
    }
}
