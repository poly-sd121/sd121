package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KichThuocRepository extends JpaRepository<KichThuoc, Long> {
    @Query("select kt from KichThuoc kt where kt.tenKichThuoc like %:tenKichThuoc%")
    List<KichThuoc> search(String tenKichThuoc);
}