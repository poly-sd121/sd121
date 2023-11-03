package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.ChatLieu;
import com.fpoly.poly121.repository.ChatLieuReponsitory;
import com.fpoly.poly121.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    private ChatLieuReponsitory chatLieuReponsitory;

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuReponsitory.findAll();
    }
}
