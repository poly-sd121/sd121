package com.fpoly.poly121.controller;



import com.fpoly.poly121.model.ChatLieu;
import com.fpoly.poly121.model.KichThuoc;
import com.fpoly.poly121.model.LoaiSanPham;
import com.fpoly.poly121.model.MauSac;
import com.fpoly.poly121.model.SanPham;
import com.fpoly.poly121.model.SanPhamChiTiet;
import com.fpoly.poly121.model.ThuongHieu;
import com.fpoly.poly121.repository.SanPhamChiTietReponsitory;
import com.fpoly.poly121.repository.SanPhamReponsitory;
import com.fpoly.poly121.service.ChatLieuService;
import com.fpoly.poly121.service.KichThuocService;
import com.fpoly.poly121.service.LoaiSanPhamService;
import com.fpoly.poly121.service.MauSacService;
import com.fpoly.poly121.service.SanPhamChiTietService;
import com.fpoly.poly121.service.SanPhamService;
import com.fpoly.poly121.service.ThuongHieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("san-pham-chi-tiet")
public class SanPhamChiTietController {
    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;
    List<SanPhamChiTiet> listSpct;

    @Autowired
    private SanPhamChiTietReponsitory sanPhamChiTietReponsitory;
    @Autowired
    private SanPhamService sanPhamService;
    List<SanPham> listSp;

    @Autowired
    private MauSacService mauSacService;
    List<MauSac> listMs;

    @Autowired
    private LoaiSanPhamService loaiSanPhamService;
    List<LoaiSanPham> listLsp;

    @Autowired
    private ThuongHieuService thuongHieuService;
    List<ThuongHieu> listTh;

    @Autowired
    private KichThuocService kichThuocService;
    List<KichThuoc> listKt;

    @Autowired
    private ChatLieuService chatLieuService;
    List<ChatLieu> listCl;

    @GetMapping("index")
    public String getAll(@RequestParam(defaultValue = "0") Integer page, Model model) {
        Page<SanPhamChiTiet> page1 = sanPhamChiTietService.getAll(page);
        listSpct = page1.getContent();
        model.addAttribute("listSpct", listSpct);
        model.addAttribute("listSp",listSp = sanPhamService.getAll());
        model.addAttribute("listMs",listMs = mauSacService.getAll());
        model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
        model.addAttribute("listKt",listKt = kichThuocService.getAll() );
        model.addAttribute("listTh",listTh = thuongHieuService.getAll());
        model.addAttribute("listCl",listCl = chatLieuService.getAll());

        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        return "san_pham_chi_tiet/index";
    }

    @PostMapping("add")
    public String add(@Validated @ModelAttribute SanPhamChiTiet sanPhamChiTiet, @RequestParam MultipartFile file, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors" , "Dien du du lieu can thiet !");
            return "redirect:/san-pham-chi-tiet/form-add";
        }
        try {
            String uploadPath = "H:\\DATN\\src\\main\\webapp\\assets\\images\\";
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String fileName = file.getOriginalFilename();
            File uploadedFile = new File(uploadPath + fileName);
            file.transferTo(uploadedFile);
            System.out.println("File uploaded to: " + uploadPath + fileName);

            // Save information to database
            sanPhamChiTiet.setLinkAnh(fileName);
            sanPhamChiTietService.add(sanPhamChiTiet);
            model.addAttribute("successMessage", "Them thanh cong");

            return "redirect:/san-pham-chi-tiet/index";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Loi nhan file");
            return "redirect:/san-pham-chi-tiet/form-add"; // Return view to display error message
        }

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute SanPhamChiTiet sanPhamChiTiet) {
        sanPhamChiTietService.update(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }

//    @PostMapping("update/")
//    public String updateEmpty(@RequestParam(defaultValue = "0") Integer page, Model model) {
//        model.addAttribute("errorsUpdate", "Chưa đủ thông tin cần cập nhật !");
//        Page<SanPhamChiTiet> page1 = sanPhamChiTietService.getAll(page);
//        listSpct = page1.getContent();
//        model.addAttribute("listSpct", listSpct);
//        model.addAttribute("page", page);
//        model.addAttribute("page1", page1.getTotalPages());
//        return "san_pham_chi_tiet/index";
//    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("listId", "Update");
        sanPhamChiTietService.delete(id);
        return "redirect:/san-pham-chi-tiet/index";
    }


    @GetMapping("form-add")
    public String formAdd( Model model) {
        model.addAttribute("listSp",listSp = sanPhamService.getAll());
        model.addAttribute("listMs",listMs = mauSacService.getAll());
        model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
        model.addAttribute("listKt",listKt = kichThuocService.getAll() );
        model.addAttribute("listTh",listTh = thuongHieuService.getAll());
        model.addAttribute("listCl",listCl = chatLieuService.getAll());

        return "san_pham_chi_tiet/add";

    }


    @GetMapping("search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        listSpct = sanPhamChiTietService.search(keyword);
        model.addAttribute("listSpct", listSpct);
        return "san_pham_chi_tiet/index";
    }

    @GetMapping("search2")
    public String search2(@RequestParam String keyword2 , @RequestParam String keyword3,@RequestParam(defaultValue = "0") Integer page,  Model model) {
        model.addAttribute("listSpct", listSpct);
        Page<SanPhamChiTiet> page1 = sanPhamChiTietService.getAll(page);
        listSpct = page1.getContent();
        model.addAttribute("page1", page1.getTotalPages());
        listSpct = sanPhamChiTietService.search2(keyword2,keyword3);
        model.addAttribute("listSpct", listSpct);
        return "san_pham_chi_tiet/index";
    }


    @GetMapping("search3")
    public String search3(@RequestParam (defaultValue = "0") String sl,@RequestParam(defaultValue = "0") Integer page, Model model) {
        listSpct = sanPhamChiTietService.search3(sl);
        model.addAttribute("listSpct", listSpct);
        Page<SanPhamChiTiet> page1 = sanPhamChiTietService.getAll(page);
        listSpct = page1.getContent();
        model.addAttribute("page1", page1.getTotalPages());

        return "san_pham_chi_tiet/index";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0") Integer page, @PathVariable Long id, Model model) {
        Page<SanPhamChiTiet> page1 = sanPhamChiTietService.getAll(page);
        listSpct = page1.getContent();
        model.addAttribute("listSpct", listSpct);
        model.addAttribute("listSp",listSp = sanPhamService.getAll());
        model.addAttribute("listMs",listMs = mauSacService.getAll());
        model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
        model.addAttribute("listKt",listKt = kichThuocService.getAll() );
        model.addAttribute("listTh",listTh = thuongHieuService.getAll());
        model.addAttribute("listCl",listCl = chatLieuService.getAll());
        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.detail(id);
        model.addAttribute("spct", sanPhamChiTiet);
        model.addAttribute("update", "Update San Pham Chi Tiet");
        return "san_pham_chi_tiet/add";
    }
}
