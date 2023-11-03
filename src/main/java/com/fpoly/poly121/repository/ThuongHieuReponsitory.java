package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuongHieuReponsitory extends JpaRepository<ThuongHieu,Long> {
}
