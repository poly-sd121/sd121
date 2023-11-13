package com.fpoly.poly121.service.impl;

import com.fpoly.poly121.model.SanPhamChiTiet;
import com.fpoly.poly121.repository.SanPhamChiTietReponsitory;
import com.fpoly.poly121.service.SanPhamChiTietService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class  SanPhamChiTietServiceImpl implements SanPhamChiTietService {
    @Autowired
    private SanPhamChiTietReponsitory sanPhamChiTietRepository;


    @Override
    public Page<SanPhamChiTiet> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return sanPhamChiTietRepository.findAll(pageable);
    }

    @Override
    public void add(SanPhamChiTiet sanPhamChiTiet, MultipartFile file) {
        String relativePath = "assets/images/imgSp/";

        try {
            String fileName = file.getOriginalFilename();
            String absolutePath = FileUtils.getFile("../../../../DATN/src/main/webapp", relativePath).getCanonicalPath();
            File uploadDir = new File(absolutePath);
            FileUtils.forceMkdir(uploadDir);
            uploadDir.setWritable(true);

            File uploadedFile = new File(uploadDir, fileName);
            uploadedFile.setWritable(true);
            file.transferTo(uploadedFile);
            System.out.println("File uploaded to: " + uploadedFile.getAbsolutePath());
            sanPhamChiTiet.setAnhSanPham("/" + relativePath + fileName);
            sanPhamChiTietRepository.save(sanPhamChiTiet);
        } catch (IOException e) {
            sanPhamChiTiet.setAnhSanPham("https://support.sapo.vn/Upload/ImageManager/Image/HaBTT/Sapoweb/San%20pham/sp6.jpg");
            sanPhamChiTietRepository.save(sanPhamChiTiet);
            e.printStackTrace();
        }

    }

    @Override
    public void update(SanPhamChiTiet sanPhamChiTiet) {

        sanPhamChiTietRepository.save(sanPhamChiTiet);

    }

    @Override
    public void delete(Long id) {
        sanPhamChiTietRepository.deleteById(id);
    }

    @Override
    public void xoaAnh(Long id) {
        String fileName = sanPhamChiTietRepository.deleteAnh(id);
        if (fileName != null) {
            String filePath = "H:\\DATN\\src\\main\\webapp\\assets\\images\\imgSp\\" + fileName; // Đường dẫn của file ảnh
            File fileToDelete = new File(filePath);
            if (fileToDelete.exists() && fileToDelete.delete()) {
                System.out.println("File đã được xóa thành công.");
                System.out.println("File đã được xóa thành công." + fileName);
            } else {
                System.out.println("Không thể xóa file hoặc file không tồn tại." + fileName);
            }
        }
    }


    @Override
    public SanPhamChiTiet detail(Long id) {
        return sanPhamChiTietRepository.getById(id);
    }

    @Override
    public List<SanPhamChiTiet> search(String keyword) {
        return sanPhamChiTietRepository.search(keyword);
    }

    @Override
    public List<SanPhamChiTiet> search2(String keyword2, String keyword3) {
        return sanPhamChiTietRepository.search2(keyword2, keyword3);
    }

    @Override
    public List<SanPhamChiTiet> search3(String sl) {
        return sanPhamChiTietRepository.search3();
    }


}
