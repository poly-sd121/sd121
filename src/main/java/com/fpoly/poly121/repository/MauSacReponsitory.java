package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacReponsitory extends JpaRepository<MauSac,Long> {
}
