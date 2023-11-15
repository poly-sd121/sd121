package com.fpoly.poly121.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpoly.poly121.model.GioHang;
import com.fpoly.poly121.model.GioHangChiTiet;
import com.fpoly.poly121.repository.GioHangChiTietRepo;
import com.fpoly.poly121.repository.GioHangRepository;
import com.fpoly.poly121.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private GioHangChiTietRepo gioHangChiTietRepo;

    @Override
    public GioHang save(JsonNode gioHang) {
        ObjectMapper mapper = new ObjectMapper();
        GioHang gioHang1 = mapper.convertValue(gioHang,GioHang.class);
        gioHangRepository.save(gioHang1);
        TypeReference<List<GioHangChiTiet>> type = new TypeReference<List<GioHangChiTiet>>() {
        };
        List<GioHangChiTiet> details = mapper.convertValue(gioHang.get("gioHangChiTiets"),type)
                .stream().peek(d->d.setIdGioHang(gioHang1)).collect(Collectors.toList());
        gioHangChiTietRepo.saveAll(details);
        return gioHang1;
    }
}
