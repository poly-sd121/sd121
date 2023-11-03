package com.fpoly.poly121.repository;

import com.fpoly.poly121.model.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatLieuReponsitory extends JpaRepository<ChatLieu,Long> {
}
