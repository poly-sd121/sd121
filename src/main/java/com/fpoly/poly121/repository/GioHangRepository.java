package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository< GioHang,Long> {
}
