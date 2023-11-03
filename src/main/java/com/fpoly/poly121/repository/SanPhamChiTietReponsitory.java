package com.fpoly.poly121.repository;


import com.fpoly.poly121.model.SanPham;
import com.fpoly.poly121.model.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietReponsitory  extends JpaRepository<SanPhamChiTiet , Long> {
//    @Query("select cl from SanPham cl where  cl.tenSanPham like %:tenSanPham%  ")
//    List<SanPham> search(String tenSanPham );
}
