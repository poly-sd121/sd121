package com.fpoly.poly121.repository;


import com.fpoly.poly121.model.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietReponsitory extends JpaRepository<SanPhamChiTiet , Long> {
    @Query("SELECT ct FROM SanPhamChiTiet ct WHERE ct.idSanPham in (select sp.id from SanPham sp where sp.tenSanPham like %:keyword%) " +
            "OR ct.idLoaiSanPham in (select sp.id from LoaiSanPham sp where sp.tenLoai like %:keyword%) " +
            "OR ct.idChatLieu in (select sp.id from ChatLieu sp where sp.tenChatLieu like %:keyword%) " +
            "OR ct.idKichThuoc in (select sp.id from KichThuoc sp where sp.tenKichThuoc like %:keyword%) " +
            "OR ct.idMauSac in (select sp.id from MauSac sp where sp.tenMauSac like %:keyword%) " +
            "OR ct.idThuongHieu in (select sp.id from ThuongHieu sp where sp.tenThuongHieu like %:keyword%) " )
    List<SanPhamChiTiet> search( String keyword);

    @Query("select  ct from SanPhamChiTiet ct where ct.giaBan >= :keyword2 and ct.giaBan <= :keyword3")
    List<SanPhamChiTiet> search2(String keyword2 , String keyword3);

    @Query("select  ct from SanPhamChiTiet ct where ct.soLuong = 0")
    List<SanPhamChiTiet> search3();

    @Query("SELECT ct.anhSanPham FROM SanPhamChiTiet ct WHERE ct.id = :id ")
    String deleteAnh(Long id);

}
