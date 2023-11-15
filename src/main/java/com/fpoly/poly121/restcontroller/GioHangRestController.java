package com.fpoly.poly121.restcontroller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.poly121.model.GioHang;
import com.fpoly.poly121.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/gio-hang")
public class GioHangRestController {
    @Autowired
    private GioHangService gioHangService;

    @PostMapping()
    public GioHang create(@RequestBody JsonNode gioHang){
        return gioHangService.save(gioHang);
    }
}
