package com.fpoly.poly121.repository;

import com.fpoly.poly121.security.dto.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
    TaiKhoan findByTenTaiKhoan(String tenTaiKhoan);
}
