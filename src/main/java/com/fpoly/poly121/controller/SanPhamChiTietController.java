package com.fpoly.poly121.controller;



import com.fpoly.poly121.model.ChatLieu;
import com.fpoly.poly121.model.KichThuoc;
import com.fpoly.poly121.model.LoaiSanPham;
import com.fpoly.poly121.model.MauSac;
import com.fpoly.poly121.model.SanPham;
import com.fpoly.poly121.model.SanPhamChiTiet;
import com.fpoly.poly121.model.ThuongHieu;
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
    public String add(@Validated @ModelAttribute SanPhamChiTiet sanPhamChiTiet, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors" , "Dien du du lieu can thiet !");
            return "redirect:/san-pham-chi-tiet/form-add";
        }
        sanPhamChiTietService.add(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute SanPhamChiTiet sanPhamChiTiet) {
        sanPhamChiTietService.update(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @PostMapping("update/")
    public String updateEmpty(@RequestParam(defaultValue = "0") Integer page, Model model) {
        model.addAttribute("errorsUpdate", "Chưa đủ thông tin cần cập nhật !");
        Page<SanPhamChiTiet> page1 = sanPhamChiTietService.getAll(page);
        listSpct = page1.getContent();
        model.addAttribute("listSpct", listSpct);
        model.addAttribute("page", page);
        model.addAttribute("page1", page1.getTotalPages());
        return "san_pham_chi_tiet/index";
    }

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

//    @GetMapping("search")
//    public String search(@RequestParam String tenSanPhamChiTiet, Model model) {
//        listSpct = sanPhamChiTietService.search(tenSanPhamChiTiet);
//        model.addAttribute("listSpct", listSpct);
//        return "san_pham_chi_tiet/index";
//    }

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
        return "san_pham_chi_tiet/index";
    }
}
