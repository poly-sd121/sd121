package com.fpoly.poly121.repository;

import com.fpoly.poly121.dto.SanPhamValue;
import com.fpoly.poly121.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamReponsitory extends JpaRepository<SanPham , Long> {
    @Query("select cl from SanPham cl where  cl.tenSanPham like %:tenSanPham%  ")
    List<SanPham> search( String tenSanPham );

    @Query(value = " select sp.tenSanPham as ten, spct.anhSanPham as anh, spct.giaBan as gia" +
            " from SanPham sp join SanPhamChiTiet spct  on sp = spct.idSanPham " +
            " where 1 = 1 " +
            " and ( :tenSp is null or :tenSp = '' or lower(sp.tenSanPham) like concat('%', lower(:tenSp), '%' ) )")
    Page<SanPhamValue> searchBanHang(String tenSp, Pageable pageable);
}
