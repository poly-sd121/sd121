package com.fpoly.poly121.repository;



import com.fpoly.poly121.model.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, Integer> {

    @Query("select cl from ChatLieu cl where cl.tenChatLieu like %:tenChatLieu%")
    List<ChatLieu> search( String tenChatLieu );
}
