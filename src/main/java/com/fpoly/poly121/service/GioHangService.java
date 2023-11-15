package com.fpoly.poly121.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.poly121.model.GioHang;


public interface GioHangService {

    GioHang  save(JsonNode gioHang);
}
