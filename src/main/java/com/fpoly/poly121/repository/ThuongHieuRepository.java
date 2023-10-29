package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu,Long> {
    @Query(value ="SELECT * FROM dbo.thuong_hieu WHERE ten_thuong_hieu LIKE %:ten%" ,nativeQuery = true)
    Page<ThuongHieu> timKiem(@Param("ten") String ten, Pageable pageable);
//    List<ThuongHieu> timKiem(@Param("ten") String ten);
}

