package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.KhachHang;
import com.fpoly.poly121.security.dto.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    KhachHang findFirstByTenTaiKhoanAndDaXoa(TaiKhoan taiKhoan, Integer daXoa);
}
