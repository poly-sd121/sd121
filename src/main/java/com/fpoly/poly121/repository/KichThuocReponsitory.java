package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.KichThuoc;
import com.fpoly.poly121.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KichThuocReponsitory extends JpaRepository<KichThuoc, Long> {

}
