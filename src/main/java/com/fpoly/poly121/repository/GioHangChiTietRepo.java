package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangChiTietRepo extends JpaRepository< GioHangChiTiet,Long> {
}
