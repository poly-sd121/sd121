package com.fpoly.poly121.dto.sanphamchitiet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SanPhamChiTietDto {
    private Long id;
    private String tenSanPham;
    private Long giaBan;
    private  Long soLuong;
}
