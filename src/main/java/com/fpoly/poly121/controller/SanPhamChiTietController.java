package com.fpoly.poly121.controller;


import com.fpoly.poly121.model.*;
import com.fpoly.poly121.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("san-pham-chi-tiet")
public class SanPhamChiTietController {
    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;
    List<SanPhamChiTiet> listSpct;

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
        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        return "san_pham_chi_tiet/index";
    }

    @PostMapping("add")
    public String add(  @RequestParam MultipartFile file,@Valid @ModelAttribute SanPhamChiTiet sanPhamChiTiet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listSp",listSp = sanPhamService.getAll());
            model.addAttribute("listMs",listMs = mauSacService.getAll());
            model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
            model.addAttribute("listKt",listKt = kichThuocService.getList());
            model.addAttribute("listTh",listTh = thuongHieuService.getAll());
            model.addAttribute("listCl",listCl = chatLieuService.getList());
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "san_pham_chi_tiet/add";
        } else {
            model.addAttribute("listSp",listSp = sanPhamService.getAll());
            model.addAttribute("listMs",listMs = mauSacService.getAll());
            model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
            model.addAttribute("listKt",listKt = kichThuocService.getList());
            model.addAttribute("listTh",listTh = thuongHieuService.getAll());
            model.addAttribute("listCl",listCl = chatLieuService.getList());
            sanPhamChiTietService.add(sanPhamChiTiet,file);
            model.addAttribute("pass" ,"Thêm thành công ✓");
            return "san_pham_chi_tiet/add";
        }
    }

    @PostMapping("update/{id}")
    public String update(@RequestParam MultipartFile file,@PathVariable Long id, @Valid @ModelAttribute SanPhamChiTiet sanPhamChiTiet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listSp",listSp = sanPhamService.getAll());
            model.addAttribute("listMs",listMs = mauSacService.getAll());
            model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
            model.addAttribute("listKt",listKt = kichThuocService.getList());
            model.addAttribute("listTh",listTh = thuongHieuService.getAll());
            model.addAttribute("listCl",listCl = chatLieuService.getList());
            model.addAttribute("errors", bindingResult.getAllErrors());
            SanPhamChiTiet sanPhamChiTiet1 = sanPhamChiTietService.detail(id);
            model.addAttribute("spct", sanPhamChiTiet1);
            return "san_pham_chi_tiet/add";
        } else {
            model.addAttribute("listSp",listSp = sanPhamService.getAll());
            model.addAttribute("listMs",listMs = mauSacService.getAll());
            model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
            model.addAttribute("listKt",listKt = kichThuocService.getList() );
            model.addAttribute("listTh",listTh = thuongHieuService.getAll());
            model.addAttribute("listCl",listCl = chatLieuService.getList());
            model.addAttribute("pass" ,"Cập nhật thành công ✓ ");
            SanPhamChiTiet sanPhamChiTiet1 = sanPhamChiTietService.detail(id);
            model.addAttribute("spct", sanPhamChiTiet1);
            sanPhamChiTietService.add(sanPhamChiTiet,file);
            return "san_pham_chi_tiet/add";
        }
    }

    @GetMapping("xoaAnh/{id}")
    public String xoaAnh(@PathVariable Long id ,Model model){
        sanPhamChiTietService.xoaAnh(id);
        return "redirect:/san-pham-chi-tiet/fileAnh";
    }

    @GetMapping("fileAnh")
    public String fileAnh(Model model,@RequestParam(defaultValue = "0") Integer page){
        Page<SanPhamChiTiet> page1 = sanPhamChiTietService.getAll(page);
        listSpct = page1.getContent();
        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        model.addAttribute("listSpct" , listSpct  );
        return "san_pham_chi_tiet/xoaAnh";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        sanPhamChiTietService.delete(id);
        return "redirect:/san-pham-chi-tiet/index";
    }


    @GetMapping("form-add")
    public String formAdd( Model model) {
        model.addAttribute("listSp",listSp = sanPhamService.getAll());
        model.addAttribute("listMs",listMs = mauSacService.getAll());
        model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
        model.addAttribute("listKt",listKt = kichThuocService.getList() );
        model.addAttribute("listTh",listTh = thuongHieuService.getAll());
        model.addAttribute("listCl",listCl = chatLieuService.getList());
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
    public String detail( @PathVariable Long id, Model model) {
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.detail(id);
        model.addAttribute("spct", sanPhamChiTiet);
        model.addAttribute("listSp",listSp = sanPhamService.getAll());
        model.addAttribute("listMs",listMs = mauSacService.getAll());
        model.addAttribute("listLsp",listLsp =loaiSanPhamService.getAll());
        model.addAttribute("listKt",listKt = kichThuocService.getList() );
        model.addAttribute("listTh",listTh = thuongHieuService.getAll() );
        model.addAttribute("listCl",listCl = chatLieuService.getList());
        return "san_pham_chi_tiet/add";
    }
}
