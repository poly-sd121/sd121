package com.fpoly.poly121.repository;
import com.fpoly.poly121.model.SanPhamChiTiet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrangChuRepository extends JpaRepository<SanPhamChiTiet,Long> {
    @Query("SELECT spct FROM SanPhamChiTiet spct " +
            "INNER JOIN SanPham sp ON spct.id = sp.id where spct.idLoaiSanPham.gioiTinh = 'Nam'" +
            "order by spct.ngayTao DESC")
    List<SanPhamChiTiet> getAllNamMoiNhat();

    @Query("SELECT spct FROM SanPhamChiTiet spct " +
            "INNER JOIN SanPham sp ON spct.id = sp.id where spct.idLoaiSanPham.gioiTinh = 'Nam'" +
            "order by spct.ngayTao DESC")
    List<SanPhamChiTiet> getAllNamNhieuNhat();

    @Query("SELECT spct FROM SanPhamChiTiet spct " +
            "INNER JOIN SanPham sp ON spct.id = sp.id where spct.idLoaiSanPham.gioiTinh != 'Nam'" +
            "order by spct.ngayTao DESC")
    List<SanPhamChiTiet> getAllNuMoiNhat();

    @Query("SELECT spct FROM SanPhamChiTiet spct " +
            "INNER JOIN SanPham sp ON spct.id = sp.id where spct.idLoaiSanPham.gioiTinh != 'Nam'" +
            "order by spct.ngayTao DESC")
    List<SanPhamChiTiet> getAllNuNhieuNhat();
}

